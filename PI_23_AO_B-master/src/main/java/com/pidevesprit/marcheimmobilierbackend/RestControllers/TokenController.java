package com.pidevesprit.marcheimmobilierbackend.RestControllers;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Token;
import com.pidevesprit.marcheimmobilierbackend.DTO.TokenResponse;
import com.pidevesprit.marcheimmobilierbackend.Services.TokenService;
import com.pidevesprit.marcheimmobilierbackend.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;


    @GetMapping("/all")
    public List<TokenResponse> findTokens() {
        return tokenService.findTokens();
    }

    @DeleteMapping("/delete")
    public void deleteToken(@RequestParam("tokenId") int tokenId) {
        tokenService.deleteTokens(tokenId);
    }

}
