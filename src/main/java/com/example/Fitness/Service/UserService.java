package com.example.Fitness.Service;

import com.example.Fitness.DTO.RegisterRequest;
import com.example.Fitness.DTO.UserResponse;
import com.example.Fitness.Repository.UserRepository;
import com.example.Fitness.model.User;
import com.example.Fitness.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder;



    public UserResponse register(RegisterRequest request) {
        //Role ke value customizable set kiye hue aur usko access karna tha
        UserRole role=request.getRole()!=null ? request.getRole() : UserRole.USER;

        //by using builder pattern
       User user=User.builder()
               .email(request.getEmail())
               .firstname(request.getFirstname())
               .lastname(request.getLastname())
              // .password(request.getPassword())    -->normally plain text password ke liye tha
               .password(passwordEncoder.encode(request.getPassword()))
               .role(role)
               .build();





//        User user=new User(
//                null,
//                request.getEmail(),
//                request.getPassword(),
//                request.getFirstname(),
//                request.getLastname(),
//                Instant.parse("2026-09-19T21:05:25.838Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                Instant.parse("2026-09-19T21:05:25.838Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                List.of(),
//                List.of()
 //       );

        User savedUser=userRepository.save(user);
        return mapToResponse(user);
    }

    public UserResponse mapToResponse(User savedUser) {
        UserResponse response=new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstname(savedUser.getFirstname());
        response.setLastname(savedUser.getLastname());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());

        return response;

    }
}
