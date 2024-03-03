package com.starter.springbootjwaauthentication.controllers;

import com.starter.springbootjwaauthentication.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/v1/auth")
public class JwtAuthenticationController {
    private final AuthenticationService authenticationService;

    public JwtAuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(
            @RequestBody RegisterRequest request
    ) {
        String token = authenticationService.register(request);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User created successfully");

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("token", token);
        response.put("data", responseData);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, Object>> authenticate(
            @RequestBody RegisterRequest request
    ) {
        String token = authenticationService.authenticate(request);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User authenticated successfully");

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("token", token);
        response.put("data", responseData);

        return ResponseEntity.ok(response);
    }
}
