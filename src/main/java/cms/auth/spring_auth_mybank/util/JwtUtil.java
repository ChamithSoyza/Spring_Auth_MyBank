package cms.auth.spring_auth_mybank.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(String username, String scopes) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("scopes", scopes);
        return createToken(claims, username);
    }

    JwtUtil() {
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

//    public Boolean validateToken(String token, String username) {
//        final String extractedusername = extractUsername(token);
//        return (extractedusername.equals(username) && !isTokenExpired(token));
//    }

    public List<GrantedAuthority> validateToken(String token) {
        if (!isTokenExpired(token)) {
            final Claims claims = extractAllClaims(token);
            String scopes = (String) claims.get("scopes");
            String[] scopesArray = scopes.split(",");
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (String scope : scopesArray) {
                authorities.add(() -> scope.trim());
            }
            return authorities;
        }
        return new ArrayList<>();
    }

    private Optional<String> extractUsername(String token) {
        if (!isTokenExpired(token)) {
            return Optional.of(extractAllClaims(token).getSubject());
        }
        return Optional.empty();
    }

//    private String extractUsername(String token) {
//        return extractAllClaims(token).getSubject();
//    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
