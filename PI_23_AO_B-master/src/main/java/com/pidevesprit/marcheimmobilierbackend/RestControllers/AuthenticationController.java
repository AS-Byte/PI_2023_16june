package com.pidevesprit.marcheimmobilierbackend.RestControllers;
import com.pidevesprit.marcheimmobilierbackend.DTO.AuthenticationRequest;
import com.pidevesprit.marcheimmobilierbackend.DTO.AuthenticationResponse;
import com.pidevesprit.marcheimmobilierbackend.DTO.RegisterRequest;
import com.pidevesprit.marcheimmobilierbackend.Services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @ModelAttribute RegisterRequest request, @RequestParam("image") MultipartFile image
    ) throws IOException {
        return ResponseEntity.ok(service.register(request, image));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        return service.confirmEmail(confirmationToken);
    }
    @PostMapping("/logout")
    public void logout(@RequestParam("email") String email) {
        service.logout(email);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody String email) {
        service.initiatePasswordReset(email);
        return ResponseEntity.ok("Email sent with instructions to reset password.");
    }
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam("token") String token, @RequestParam("password") String password) {
        service.resetPassword(token, password);
        return ResponseEntity.ok("Password reset successfully.");
    }
    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@ModelAttribute RegisterRequest request, @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        service.updateUser(request, image);
        return ResponseEntity.ok("Account updated successfully.");
    }
}