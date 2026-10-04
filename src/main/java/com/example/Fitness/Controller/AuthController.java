package com.example.Fitness.Controller;


import com.example.Fitness.DTO.LoginRequest;
import com.example.Fitness.DTO.LoginResponse;
import com.example.Fitness.DTO.RegisterRequest;
import com.example.Fitness.DTO.UserResponse;
import com.example.Fitness.Repository.UserRepository;
import com.example.Fitness.Security.JwtUtils;
import com.example.Fitness.Service.UserService;
import com.example.Fitness.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private  final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/register")
//    ye user se connect kar db me store hota tha
//    public User register(@RequestBody  User user){
//        return userService.regsiter(user);

//    public UserResponse register(@RequestBody RegisterRequest registerRequest){
//        return userService.register(registerRequest);
//    }


    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        //validation code
        return ResponseEntity.ok( userService.register(registerRequest));
    }



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)  {
        Authentication authentication ;
        try {
//verified user ke hi access karega
//            authentication=  authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
//                            loginRequest.getPassword()
//                    )
//            );


            // humme to custom user ke liye banana taki usse access kare aur validity bhi kar denge
           User user=userRepository.findByEmail(loginRequest.getEmail());

           if(user==null)
               return ResponseEntity.status(401).build();



           if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
               return ResponseEntity.status(401).build();
           }


           String token=jwtUtils.generateToken(user.getId(),user.getRole().name());

           return ResponseEntity.ok(new LoginResponse(token, userService.mapToResponse(user)
           ));





        }catch (AuthenticationException e){
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }

//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        UserDetails userDetails= (UserDetails) authentication.getPrincipal();
//
//        String jwtToken=jwtUtils.generateTokenFromUsername(userDetails);
//        return jwtToken;

    }



}
