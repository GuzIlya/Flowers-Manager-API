package net.guz.flowersmanagerapi.security.awt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import net.guz.flowersmanagerapi.security.awt.exception.JwtAuthenticationException;
import net.guz.flowersmanagerapi.security.awt.exception.JwtValidationException;
import net.guz.flowersmanagerapi.entity.Florist;
import net.guz.flowersmanagerapi.entity.Terminal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTerminalTokenProvider {

    @Value("${jwt.token.terminal.secret}")
    private String secret;

    @Value("${jwt.token.terminal.expired}")
    private long validityInMilliseconds;

    public String resolveToken(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            log.info("IN resolveToken - token: {}", bearerToken.substring(7));
            return bearerToken.substring(7);
        } throw new IllegalArgumentException("Token not found");
    }

    public boolean validateToken(String token) throws JwtValidationException {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            if (claims.getBody().getExpiration().before(new Date())) {
                throw new JwtValidationException("Token expired");
            }

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthenticationException("JWT token is expired or invalid");
        }
    }

    public Jws<Claims> getClaims(String token){
        Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        return claims;
    }

    public String createToken(Florist florist, Terminal terminal) {

        Claims claims = Jwts.claims();
        claims.put("florist_id", florist.getId());
        claims.put("terminal_id", terminal.getId());

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()//
                .setClaims(claims)//
                .setIssuedAt(now)//
                .setExpiration(validity)//
                .signWith(SignatureAlgorithm.HS256, secret)//
                .compact();
    }
}
