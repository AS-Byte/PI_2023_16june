package com.pidevesprit.marcheimmobilierbackend.Services.Interfaces;

import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Token;
import com.pidevesprit.marcheimmobilierbackend.DTO.TokenResponse;

import java.util.List;

public interface ITokenService {
    List<TokenResponse> findTokens();

    void deleteTokens(Integer tokenId);

    List<Token> findFiltredToken(String filterType);
}
