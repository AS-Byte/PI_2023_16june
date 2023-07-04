package com.pidevesprit.marcheimmobilierbackend.Services;


import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Token;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.User;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TokenType;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.TokenRepository;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.UserRepository;
import com.pidevesprit.marcheimmobilierbackend.DTO.AuthenticationRequest;
import com.pidevesprit.marcheimmobilierbackend.DTO.AuthenticationResponse;
import com.pidevesprit.marcheimmobilierbackend.DTO.RegisterRequest;
import com.pidevesprit.marcheimmobilierbackend.SecurityConfiguration.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    EmailService emailService;

    public AuthenticationResponse register(RegisterRequest request, MultipartFile image) throws IOException {

        byte[] imageData = image.getBytes();

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .role(request.getRole())
                .password(passwordEncoder.encode(request.getPassword()))
                .image(imageData)
                .build();
        User savedUser = repository.save(user);

        /*---- token generator  ----*/

        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        System.out.println("Confirmation Token: " + jwtToken + "email recived :" + user.getEmail());

        /*---- mail sender ----*/

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8080/v1/auth/confirm-account?token=" + jwtToken);
        emailService.sendEmail(mailMessage);

        /*---- return response ----*/
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken).authUser(user.getEmail()).role(user.getRole())
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .issueAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    public void revokeAllUserTokens(User user) {
        User userToRestrict = repository.findByEmail(user.getEmail()).orElseThrow(null);

        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        userToRestrict.setEnabled(false);
        tokenRepository.saveAll(validUserTokens);
    }

    private void revokeAllUserTokensByEmail(User user) {
        List<Token> validUserTokens = tokenRepository.findAllTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public ResponseEntity<?> confirmEmail(String confirmationToken) {
        Token token = tokenRepository.findByToken(confirmationToken).orElse(null);

        if (token != null) {
            User user = repository.findByEmail(token.getUser().getEmail()).orElseThrow();
            user.setEnabled(true);
            repository.save(user);
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
    }


    public void logout(String email) {
        User user = repository.findByEmail(email)
                .orElseThrow();
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }


    public void initiatePasswordReset(String email) {
        User user = repository.findByEmail(email).orElse(null);

        var jwtToken = jwtService.generateToken(user);
        saveUserToken(user, jwtToken);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Forget Password");
        mailMessage.setText("To reset your password, please click here : "
                + "http://localhost:4200/reset-password?token=" + jwtToken);
        emailService.sendEmail(mailMessage);

    }

    public void resetPassword(String resetToken, String password) {
        Token token = tokenRepository.findByToken(resetToken).orElse(null);
        if (token != null) {
            User user = repository.findByEmail(token.getUser().getEmail()).orElseThrow();
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(password));
            repository.save(user);
        }

    }

    public void updateUser(RegisterRequest request, MultipartFile image) throws IOException {

        User user = repository.findByEmail(request.getEmail()).orElseThrow();
        if(request.getFirstname()!=null){
        user.setFirstname(request.getFirstname());}
        if(request.getLastname()!=null){
        user.setLastname(request.getLastname());}
        if(request.getAddress()!=null){
        user.setAddress(request.getAddress());}
        if(request.getBirthdate()!=null){
        user.setBirthdate(request.getBirthdate());}
        if(request.getProfession()!=null){
        user.setProfession(request.getProfession());}
        if(request.getNum()!=null) {
            user.setNum(request.getNum());
        }
        if (image != null) {
            byte[] imageData = image.getBytes();
            user.setImage(imageData);
        }
        if (request.getPassword()!=null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        if(request.getRole()!=null){
            user.setRole(request.getRole());
        }
        repository.save(user);
    }
}
