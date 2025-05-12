package com.sudodeveloper.financetracker.service;

import com.sudodeveloper.financetracker.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
  @Value("${jwt.secret}")
  private String jwtSecret;

  @Value("${jwt.expiration}")
  private long jwtExpirationSecs;

  public String generateToken(User user) {
    return Jwts.builder()
        .subject(user.getName())
        .issuedAt(new Date())
        .expiration(new Date((new Date()).getTime() + jwtExpirationSecs))
        .signWith(SignatureAlgorithm.HS256, jwtSecret)
        .compact();
  }
}
