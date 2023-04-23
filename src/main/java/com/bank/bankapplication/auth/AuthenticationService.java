package com.bank.bankapplication.auth;


import com.bank.bankapplication.config.JwtService;
import com.bank.bankapplication.entity.Role;
import com.bank.bankapplication.entity.User;

import com.bank.bankapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .firstName(request.getFirstname())
                        .lastName(request.getLastname())
                                .email(request.getUsername())
                                        .pass(passwordEncoder.encode(request.getPassword()))
                                                .role(Role.ADMIN)
                                                        .build();
//        User user = new User(request.getUsername(), request.getPassword());
//
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public String validateUsert(ValidateRequest request){
        var user = repository.findByEmail(request.getUsername()).orElseThrow();
        return user.getFirstName();
    }

}
