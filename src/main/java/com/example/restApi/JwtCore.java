package com.example.restApi;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;


import java.util.Date;

@Component
public class JwtCore {
    @Value("${restApi.app.secret}")
    private String secret;
    @Value("${restApi.app.lifetime}")
    private int lifetime;
    public String generateToken(Authentication Authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) Authentication.getPrincipal();
        return Jwts.builder().setSubject((userDetails.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + lifetime))
    .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    public String getNameFromJwt(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
