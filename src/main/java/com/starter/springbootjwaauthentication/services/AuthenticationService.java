package com.starter.springbootjwaauthentication.services;

import com.starter.springbootjwaauthentication.controllers.RegisterRequest;
import com.starter.springbootjwaauthentication.models.Role;
import com.starter.springbootjwaauthentication.models.User;
import com.starter.springbootjwaauthentication.repositories.JwtAuthenticationRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  private final PasswordEncoder passwordEncoder;
  private final JwtAuthenticationRepository jwtAuthenticationRepository;
  private final JwtAuthenticationService jwtAuthenticationService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationService(PasswordEncoder passwordEncoder, JwtAuthenticationRepository jwtAuthenticationRepository, JwtAuthenticationService jwtAuthenticationService, AuthenticationManager authenticationManager) {
      this.passwordEncoder = passwordEncoder;
      this.jwtAuthenticationRepository = jwtAuthenticationRepository;
      this.jwtAuthenticationService = jwtAuthenticationService;
      this.authenticationManager = authenticationManager;
  }


  public String register(RegisterRequest request) {
    User user = User
            .builder()
            .email(request.getEmail())
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();

    jwtAuthenticationRepository.save(user);
    return jwtAuthenticationService.generateToken(user);
  }

  public String authenticate(RegisterRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            )
    );

    var user = jwtAuthenticationRepository.findByUsername(request.getUsername()).orElseThrow();
    return jwtAuthenticationService.generateToken(user);
  }
}
