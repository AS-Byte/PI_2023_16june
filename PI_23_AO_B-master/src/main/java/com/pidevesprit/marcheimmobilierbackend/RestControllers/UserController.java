package com.pidevesprit.marcheimmobilierbackend.RestControllers;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.User;
import com.pidevesprit.marcheimmobilierbackend.DTO.UserResponse;
import com.pidevesprit.marcheimmobilierbackend.Services.AuthenticationService;
import com.pidevesprit.marcheimmobilierbackend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;
    @GetMapping("/user-list")
    public List<UserResponse> findUsers() {
        return userService.findAllUsers().stream()
                .map(user -> new UserResponse(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getProfession(), user.getNum(), user.getBirthdate(), user.getRole(), user.getImage()))
                .collect(Collectors.toList());
    }
    @GetMapping("/current-user")
    public UserResponse findCurrentUser(@RequestParam("email") String email) {
        return userService.findCurrentUser(email);

    }

    @PostMapping("/restrict")
    public void restrictUser(@RequestBody int userId) {
        User user = userService.findUserById(userId);authenticationService.revokeAllUserTokens(user);
    }

    @GetMapping("/data")
    public HashMap<String, ?> getDashbordData() {
        return userService.dataTracking();
    }
}
