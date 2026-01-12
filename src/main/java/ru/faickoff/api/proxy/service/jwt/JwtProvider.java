package ru.faickoff.api.proxy.service.jwt;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import ru.faickoff.api.proxy.exception.TokenValidationException;

@Service
@Log4j2
public class JwtProvider {

    private final SecretKey jwtAccessSecret;

    public JwtProvider(@Value("${ru.faickoff.api.auth.jwt.secret.access}") String jwtAccessSecret) {
        this.jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecret));
    }

    public boolean validateAccessToken(@NonNull String accessToken) throws TokenValidationException {
        return this.validateToken(accessToken, this.jwtAccessSecret);
    }

    public Claims getAccessClaims(@NonNull String token) {
        return this.getClaims(token, jwtAccessSecret);
    }

    private boolean validateToken(@NonNull String token, @NonNull SecretKey secret) throws TokenValidationException {
        try {
            Jwts.parser()
                    .verifyWith(secret)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch (ExpiredJwtException e) {
            throw new TokenValidationException("Token expired", e);
        } catch (UnsupportedJwtException e) {
            throw new TokenValidationException("Unsupported jwt", e);
        } catch (MalformedJwtException e) {
            throw new TokenValidationException("Malformed jwt", e);
        } catch (Exception e) {
            throw new TokenValidationException("invalid token", e);
        }
    }

    private Claims getClaims(@NonNull String token, @NonNull SecretKey secret) {
        return Jwts.parser()
                .verifyWith(secret)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
