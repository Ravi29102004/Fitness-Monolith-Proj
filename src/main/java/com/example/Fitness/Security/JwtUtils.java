package com.example.Fitness.Security;


//---------------Helper Class-----------------------//

//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.List;
//
////import static jdk.internal.org.jline.keymap.KeyMap.key;
////import static jdk.internal.org.Key;
//
//@Component
//public class JwtUtils {
//
//
//    private static String jwtSecret="YS1zdHJpbmctc2VjcmV0LWF0LWxlYXN0LTI1Ni1iaXRzLWxvbmc=";
//    private int jwtExpirationMs=172800000;
//
//
//
//
//    public String getJwtFromHeader(HttpServletRequest request){
//        String bearerToken=request.getHeader("Authorization");
//        if(bearerToken!=null && bearerToken.startsWith("Bearer "))
//            return bearerToken.substring(7);
//
//        return null;
//    }
//
//
////    public String generateTokenFromUsername(UserDetails userDetails){
////
////        String userName= userDetails.getUsername();
////
////        return Jwts.builder()
////                .subject(userName)
////                .claim("roles",userDetails.getAuthorities().stream()
////                        .map(GrantedAuthority::getAuthority)
////                        .toList())
////                .issuedAt(new Date())
////                .expiration(new Date(new Date().getTime()+jwtExpirationMs))
////                .signWith(Key())
////                .compact();
////    }
//
//
//    public boolean validateJwtToken(String jwtToken){
//        try {
//            Jwts.parser().verifyWith(Key())
//                    .build().
//                    parseSignedClaims(jwtToken);
//
//            return true;
//        }catch (Exception e){
////            e.printStackTrace();
////        }
////        return true;
//            System.out.println("Invalid JWT Token: " + e.getMessage());
//
//            return false;
//    }
//
//    private static SecretKey Key(){
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
//
//    }
//
//
//    public String getUserIdFromToken(String jwt) {
//        return Jwts.parser().verifyWith(Key())
//                .build().parseSignedClaims(jwt)
//                .getPayload().getSubject();
//
//    }
//
//
//    public static Claims getAllClaims(String jwt) {
//        return  Jwts.parser().verifyWith((SecretKey) Key())
//                .build().parseSignedClaims(jwt)
//                .getPayload();
//    }
//
//
//    public String generateToken(String userId, String role) {
//        return Jwts.builder()
//                .subject(userId)
//                .claim("roles", List.of(role))
//                .issuedAt(new Date())
//                .expiration(new Date(new Date().getTime() + jwtExpirationMs))
//                .signWith( Key())
//                .compact();
//    }
//
//
//}


















import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {

    private static String jwtSecret =
            "YS1zdHJpbmctc2VjcmV0LWF0LWxlYXN0LTI1Ni1iaXRzLWxvbmc=";

    private int jwtExpirationMs = 172800000;

    public String getJwtFromHeader(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public boolean validateJwtToken(String jwtToken) {

        try {

            Jwts.parser()
                    .verifyWith(Key())
                    .build()
                    .parseSignedClaims(jwtToken);

            return true;

        } catch (Exception e) {

            System.out.println("Invalid JWT Token: " + e.getMessage());

            return false;
        }
    }

    private static SecretKey Key() {

        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    public String getUserIdFromToken(String jwt) {

        return Jwts.parser()
                .verifyWith(Key())
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .getSubject();
    }

    public Claims getAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(Key())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String generateToken(String userId, String role) {

        return Jwts.builder()
                .subject(userId)
                .claim("roles", List.of(role))
                .issuedAt(new Date())
                .expiration(new Date(
                        new Date().getTime() + jwtExpirationMs
                ))
                .signWith(Key())
                .compact();
    }
}