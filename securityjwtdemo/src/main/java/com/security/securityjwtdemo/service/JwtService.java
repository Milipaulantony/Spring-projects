package com.security.securityjwtdemo.service;

import com.security.securityjwtdemo.controller.EmployeeController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    private final String SECRET =
            "mysecretkeymysecretkeymysecretkey";

    public String generateToken(String username) {
        logger.info("****JWTINFO*****::Token generating here");
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 86400000))
                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()))
                .compact();
    }

    public String extractUsername(String token) {
        logger.info("****JWTINFO*****::Extract Username here");
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(
                        SECRET.getBytes()))
                .build().parseSignedClaims(token).getPayload().getSubject();

    }
}
