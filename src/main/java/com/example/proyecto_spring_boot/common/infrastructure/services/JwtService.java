package com.example.proyecto_spring_boot.common.infrastructure.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SIGNATURE = "a-string-secret-at-least-256-bits-long";
    private static final long TOKEN_EXPIRATION = 600000;
    public String generateToken(UserDetails user){

        Map<String , List<String>> authorities = Map.of("authorities",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
        return generateToken(user.getUsername(),authorities);
    }

    private String generateToken(String user, Map<String , List<String>> authorities){
        return Jwts.builder()
                .setSubject(user)
                .setClaims(authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+TOKEN_EXPIRATION))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getKey(){
        return Keys.hmacShaKeyFor(SIGNATURE.getBytes());
    }
    private Claims getAllClaims(String token) {

        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

        } catch (ExpiredJwtException e) {
            return e.getClaims();
        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            throw new RuntimeException("Invalid JWT token or mal formed", e);
        }
    }

    public String getSubject(String token){
        return getAllClaims(token).getSubject();
    }


}
