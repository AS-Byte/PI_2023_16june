package com.pidevesprit.marcheimmobilierbackend.Services;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Token;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.User;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.TokenRepository;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.UserRepository;
import com.pidevesprit.marcheimmobilierbackend.DTO.UserResponse;
import com.pidevesprit.marcheimmobilierbackend.SecurityConfiguration.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    JwtService jwtService;
    @Autowired
    TokenRepository tokenRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public UserResponse findCurrentUser(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        UserResponse userResponse = new UserResponse(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getProfession(), user.getNum(), user.getBirthdate(), user.getRole(), user.getImage());
        return userResponse;

    }


    public void restrictUser(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user.isEnabled()) {
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }
    }

    public User findUserById(int userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public HashMap<String, ?> dataTracking() {
        HashMap<String, Integer> data = new HashMap<>();
        int userNumber = 0;
        int sessionNumber = 0;
        int userActif = 0;
        int userInactif = 0;
        int userAdmin = 0;
        int userClient = 0;

        int revokedToken = 0;
        int expiredToken = 0;

        List<User> userList = userRepository.findAll();
        List<Token> tokenList = tokenRepository.findAll();
        userNumber = userRepository.findAll().size();
        sessionNumber = tokenRepository.findAll().size();

        userAdmin = (int) userList.stream().filter(user -> Objects.equals(user.getRole(), "ADMIN")).count();
        userClient = userNumber - userAdmin;
        userActif = userList.stream().filter(user -> user.isEnabled()).collect(Collectors.toList()).size();
        userInactif = userNumber - userActif;

        revokedToken = (int) tokenList.stream().filter(token -> token.isRevoked()).count();
        expiredToken = (int) tokenList.stream().filter(token -> token.isExpired()).count();

        data.put("user_number", userNumber);
        data.put("session_number", sessionNumber);
        data.put("user_actif", userActif);
        data.put("user_inactif", userInactif);
        data.put("user_role_admin", userAdmin);
        data.put("user_role_client", userClient);
        data.put("token_number", sessionNumber);
        data.put("revoked_token", revokedToken);
        data.put("expired_token", expiredToken);
        return data;
    }
}