//package br.com.alura.oficina.mecanima.infra.security;
//
//import br.com.alura.oficina.mecanima.usuario.Usuario;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//import java.util.Date;
//
//@Service
//public class TokenService {
//
//    public String gerarToken(Usuario usuario) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256("123456");
//            return JWT.create()
//                    .withIssuer("barbearia.alura.com")
//                    .withSubject(usuario.getLogin())
//                    .withExpiresAt(dataExpiracao())
//                    .sign(algorithm);
//        } catch (JWTCreationException exception){
//            throw new RuntimeException("token jwt invalido ou expirado");
//        }
//    }
//
//
//    public String getSubject(String tokenJWt) {
//
//        try {
//            Algorithm algorithm = Algorithm.HMAC256("123456");
//            return JWT.require(algorithm)
//                    .withIssuer("barbearia.alura.com")
//                    .build()
//                    .verify(tokenJWt)
//                    .getSubject() ;
//
//        } catch (JWTVerificationException exception){
//            throw new RuntimeException("token jwt invalido ou expirado");
//        }
//    }
//
//    private Instant dataExpiracao() {
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//    }
//}
