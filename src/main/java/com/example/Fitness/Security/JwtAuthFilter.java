//package com.example.Fitness.Security;
//
//
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.hibernate.mapping.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//
//
////------------------Autherization-------------------//
//
//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//    @Autowired
//    private JwtUtils jwtUtils;
//
////    @Autowired
////    private UserDetailsService userDetailsService;
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("AuthTokenFilter Called");
//
//        try{
//            String jwt=parseJwt(request);
//            if(jwt!=null && jwtUtils.validateJwtToken(jwt)){
//                String userId=jwtUtils.getUserIdFromToken(jwt);
//                //Security Context
//                //  UserDetails userDetails= userDetailsService.loadUserByUsername(username);
//
//                Claims claims=JwtUtils.getAllClaims(jwt);
////                List<Map<String, String>> roles=claims.get("roles", List.class);
//                List<Map<String, String>> roles =
//                        claims.get("roles", List.class);
//                System.out.println("roles: "+roles);
//                List<GrantedAuthority> authorities=roles.stream()
//                        .map(role->(GrantedAuthority) new SimpleGrantedAuthority(role.get("authority")))
//                        .toList();
//
//                UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userId, null, authorities);
//
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        //filterchain ke aage wala call nahi kar paa raha tha to tabhi iss isues ko resolve karne ke liye humm filterchain.dofilter ke logic build and create kiye taki usse continue rahe hai
//
//        filterChain.doFilter(request, response);
//
//
//    }
//
//    private String parseJwt(HttpServletRequest request){
//        String jwt=jwtUtils.getJwtFromHeader(request);
//        return jwt;
//    }
//}








//package com.example.Fitness.Security;
//
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain)
//            throws ServletException, IOException {
//
//        System.out.println("AuthTokenFilter Called");
//
//        try {
//
//            String jwt = parseJwt(request);
//
//            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
//                System.out.println("TOKEN THERE: " + jwt);
//
//                String userId = jwtUtils.getUserIdFromToken(jwt);
//
//                // Security Context
////                Claims claims = JwtUtils.getAllClaims(jwt);
////
////                List<String> roles =
////                        claims.get("roles", List.class);
////
////                System.out.println("roles: " + roles);
////
////                List<SimpleGrantedAuthority> authorities = roles.stream()
////                        .map(role -> new SimpleGrantedAuthority(role.get("authority")))
////                        .toList();
//
////                Claims claims = jwtUtils.getAllClaims(jwt);
////                List<String> roles = claims.get("roles", List.class);
////                System.out.println("ROLES: " + roles);
////                List<GrantedAuthority> authorities = List.of();
////                if (roles != null) {
////                    authorities = roles
////                            .stream()
////                            .map(role -> (GrantedAuthority) new SimpleGrantedAuthority(role))
////                            .toList();
////                }
//
//
////                Claims claims = jwtUtils.getAllClaims(jwt);
////
////                List<String> roles = claims.get("roles", List.class);
////
////                System.out.println("ROLES: " + roles);
////
////                List<SimpleGrantedAuthority> authorities = List.of();
////
////                if (roles != null) {
////                    authorities = roles.stream()
////                            .map(SimpleGrantedAuthority::new)
////                            .toList();
////                    claims.put("roles", roles);
////                }
//
//
//
////                Claims claims = jwtUtils.getAllClaims(jwt);
////                List<String> roles = claims.get("roles", List.class);
////                System.out.println("ROLES: " + roles);
//////                List<SimpleGrantedAuthority> authorities = List.of();
////                List<GrantedAuthority> authorities = List.of();
////                if (roles != null) {
////                    authorities = roles
////                            .stream()
////                           // .map(role -> (SimpleGrantedAuthority) new SimpleGrantedAuthority(role))
////                            .map(SimpleGrantedAuthority::new)
////                            .toList();
////                }
//
////                Claims claims = jwtUtils.getAllClaims(jwt);
////
////                List<String> roles = claims.get("roles", List.class);
////
////                System.out.println("ROLES: " + roles);
////
////                List<GrantedAuthority> authorities = List.of();
////
////                if (roles != null) {
////                    authorities = roles.stream()
////                            .map(role -> (GrantedAuthority) new SimpleGrantedAuthority(role))
////                            .toList();
////                }
//
//
//
//                Claims claims = jwtUtils.getAllClaims(jwt);
//
//                List<?> roles = claims.get("roles", List.class);
//
//                System.out.println("ROLES: " + roles);
//
//                List<GrantedAuthority> authorities = List.of();
//
//                if (roles != null) {
//                    authorities = roles.stream()
//                            .map(role -> {
//                                if (role instanceof String) {
//                                    return (GrantedAuthority) new SimpleGrantedAuthority((String) role);
//                                }
//
//                                if (role instanceof java.util.Map<?, ?> map) {
//                                    Object authority = map.get("authority");
//
//                                    if (authority != null) {
//                                        return (GrantedAuthority)
//                                                new SimpleGrantedAuthority(authority.toString());
//                                    }
//                                }
//
//                                return null;
//                            })
//                            .filter(java.util.Objects::nonNull)
//                            .toList();
//                }
//
//
//
//
//
//                UsernamePasswordAuthenticationToken authentication =
//                        new UsernamePasswordAuthenticationToken(
//                                userId,
//                                null,
//                                authorities
//                        );
//
//                authentication.setDetails(
//                        new WebAuthenticationDetailsSource()
//                                .buildDetails(request)
//                );
//
//                SecurityContextHolder
//                        .getContext()
//                        .setAuthentication(authentication);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String parseJwt(HttpServletRequest request) {
//        String jwt = jwtUtils.getJwtFromHeader(request);
//        return jwt;
//    }
//}
//
//
//
//
//
//







package com.example.Fitness.Security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("AuthTokenFilter Called");

        try {

            String jwt = parseJwt(request);

            if (jwt != null) {

                System.out.println("TOKEN THERE: " + jwt);

                if (jwtUtils.validateJwtToken(jwt)) {

                    String userId =
                            jwtUtils.getUserIdFromToken(jwt);

                    System.out.println(
                            "USER ID FROM TOKEN: " + userId
                    );

                    Claims claims =
                            jwtUtils.getAllClaims(jwt);

                    List<?> roles =
                            claims.get("roles", List.class);

                    System.out.println(
                            "ROLES: " + roles
                    );

                    List<GrantedAuthority> authorities =
                            List.of();

                    if (roles != null) {

                        authorities = roles.stream()
                                .map(role -> {

                                    if (role instanceof String) {

                                        return (GrantedAuthority)
                                                new SimpleGrantedAuthority(
                                                        (String) role
                                                );
                                    }

                                    if (role instanceof Map<?, ?> map) {

                                        Object authority =
                                                map.get("authority");

                                        if (authority != null) {

                                            return (GrantedAuthority)
                                                    new SimpleGrantedAuthority(
                                                            authority.toString()
                                                    );
                                        }
                                    }

                                    return null;
                                })
                                .filter(Objects::nonNull)
                                .toList();
                    }

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    userId,
                                    null,
                                    authorities
                            );

                    authentication.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request)
                    );

                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(authentication);
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "JWT Authentication Error: "
                            + e.getMessage()
            );
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {

        return jwtUtils.getJwtFromHeader(request);
    }
}