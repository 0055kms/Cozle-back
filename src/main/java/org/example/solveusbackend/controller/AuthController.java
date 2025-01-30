package org.example.solveusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.solveusbackend.dto.LoginRequest;
import org.example.solveusbackend.dto.LoginResponse;
import org.example.solveusbackend.dto.SignUpRequest;
import org.example.solveusbackend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody SignUpRequest signUpRequest) {
        authService.signUp(signUpRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse tokens = authService.login(loginRequest);
        return ResponseEntity.ok(tokens);
    }
}
