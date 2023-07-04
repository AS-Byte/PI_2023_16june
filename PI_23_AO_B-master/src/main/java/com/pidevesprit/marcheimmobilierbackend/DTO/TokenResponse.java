package com.pidevesprit.marcheimmobilierbackend.DTO;
import com.pidevesprit.marcheimmobilierbackend.DAO.Enumeration.TokenType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {
    public Integer id;
    public String token;
    public TokenType tokenType;
    public boolean revoked;
    public boolean expired;
    public String userEmail;
    public Integer userId;
    public Date expiration;
    public Date issueAt;
}