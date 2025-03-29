package com.example.restApi;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

@Component
public class JwtCore {
    @Value("${restApi.app.secret}")
    private String secret;
    @Value("${restApi.app.lifetime}")
    private int lifetime;
    public String generateToken(Authentication Authentication){
        return null;
    }
}
