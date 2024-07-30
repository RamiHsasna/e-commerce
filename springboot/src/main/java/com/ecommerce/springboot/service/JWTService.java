package com.ecommerce.springboot.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ecommerce.springboot.model.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    @Value("${jwt.algorithm.key}")
    private String algorithmKey;
    @Value("{$jwt.issuer}")
    private static String issuer;
    @Value("{$jwt.expiryInSeconds}")
    private static long expiryInSeconds;
    private static Algorithm algorithm;
    private static final String USERNAME_KEY = "USERNAME";

    @PostConstruct
    public void postConstruct() {
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public static String generateJWT(Customer customer){
        return JWT.create()
                .withClaim(USERNAME_KEY, customer.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+(1000*expiryInSeconds)))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public String getUsername(String token){
        return JWT.decode(token).getClaim(USERNAME_KEY).asString();
    }
}
