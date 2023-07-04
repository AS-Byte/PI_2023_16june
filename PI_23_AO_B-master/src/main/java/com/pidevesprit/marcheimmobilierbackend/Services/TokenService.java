package com.pidevesprit.marcheimmobilierbackend.Services;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.Token;
import com.pidevesprit.marcheimmobilierbackend.DAO.Entities.User;
import com.pidevesprit.marcheimmobilierbackend.DAO.Repositories.TokenRepository;
import com.pidevesprit.marcheimmobilierbackend.DTO.TokenResponse;
import com.pidevesprit.marcheimmobilierbackend.Services.Interfaces.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class TokenService implements ITokenService {
    @Autowired
    TokenRepository tokenRepository;
    public List<TokenResponse> findTokens() {
        List<Token> tokens = tokenRepository.findAll();
        List<TokenResponse> tokenList = new ArrayList<>();
        for (Token token : tokens) {
            TokenResponse tokenDTO = new TokenResponse(
                    token.id,
                    token.token,
                    token.tokenType,
                    token.revoked,
                    token.expired,
                    token.user.getEmail(),
                    token.user.getId(), token.expiration, token.issueAt
            );
            tokenList.add(tokenDTO);
        }
        return tokenList;
    }
    public void deleteTokens(Integer tokenId) {
        tokenRepository.deleteById(tokenId);
    }
    public List<Token> findFiltredToken(String filterType) {
        List<Token> initialList = tokenRepository.findAll();

        if (!filterType.isEmpty()) {
            if (Objects.equals(filterType, "expired")) {
                initialList.stream().filter(Token::isExpired).collect(Collectors.toList());
            } else if (Objects.equals(filterType, "not-expired")) {
                initialList.stream().filter(token -> !token.isExpired()).collect(Collectors.toList());
            }
        }
        return initialList;
    }

    public List<Token> findTokenByUser(int userId) {
        return tokenRepository.findAllTokenByUser(userId);
    }

    public void numberOfConnectionPerLast5days() {
        List<Token> tokens = tokenRepository.findAll();

        // Step 1: Sort the `tokens` list in descending order based on `issueAt` date
        tokens.sort(Comparator.comparing(Token::getIssueAt).reversed());

        // Step 2: Create a map to group tokens by the associated user
        Map<User, List<Token>> tokensByUser = tokens.stream()
                .collect(Collectors.groupingBy(Token::getUser));
        // Step 3: Retrieve the last 5 tokens per user and store them in a new list
        List<Token> last5TokensPerUser = new ArrayList<>();
        for (List<Token> userTokens : tokensByUser.values()) {
            List<Token> last5Tokens = userTokens.stream()
                    .limit(5)
                    .collect(Collectors.toList());
            last5TokensPerUser.addAll(last5Tokens);
        }
        // Step 4: Display the three lists
        System.out.println("Last 5 Tokens Per User:");
        for (Token token : last5TokensPerUser) {
            System.out.println(token.getToken());
        }
    }
}
