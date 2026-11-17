package com.klu.springmvc.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Service
public class JWTService {

    public String generateJWT(Map<String, String> u1, String role, Integer id) {

        String key = "hdgfkhdsfhkjdsfhkrhfdsjkhfkjdsfjkdfhlnfhf";

        SecretKey skey = Keys.hmacShaKeyFor(key.getBytes());

        Map<String, String> claim = new HashMap<>();

        claim.put("un", u1.get("username"));
        claim.put("role", role);
        claim.put("id", id.toString());

        return Jwts.builder()
                .claims(claim)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + 86400000))
                .signWith(skey)
                .compact();
    }
}