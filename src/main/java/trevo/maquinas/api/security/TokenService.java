package trevo.maquinas.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import trevo.maquinas.api.model.User;
import java.util.Date;

@Service
public class TokenService {
    private static final long TOKEN_EXPIRATE = 8000_000;
    @Value("${api.security.token.secret}")
    private String secret;
    public String token(User user ) {
        try {
//            System.out.println(secret);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API.Trevo")
                    .withSubject(user.getLogin())
                    .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATE))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o Token JWT", exception);
        }

    }
    public String getSecret(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("API.Trevo").build().verify(token).getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou inspirado!");
        }
    }
}
