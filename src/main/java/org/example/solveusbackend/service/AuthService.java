package org.example.solveusbackend.service;

import lombok.RequiredArgsConstructor;
import org.example.solveusbackend.dto.LoginRequest;
import org.example.solveusbackend.dto.LoginResponse;
import org.example.solveusbackend.dto.SignUpRequest;
import org.example.solveusbackend.entity.RefreshToken;
import org.example.solveusbackend.entity.User;
import org.example.solveusbackend.jwt.JwtTokenProvider;
import org.example.solveusbackend.repository.RefreshTokenRepository;
import org.example.solveusbackend.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public void signUp(SignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        User newUser = new User();
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setNickname(request.getNickname());

        userRepository.save(newUser);
    }

    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        String accessToken = jwtTokenProvider.generateToken(user, Duration.ofHours(2));
        String refreshToken = jwtTokenProvider.generateToken(user, Duration.ofDays(14));

        refreshTokenRepository.findByUserId(user.getId().longValue())
                .ifPresentOrElse(
                        token -> {
                            token.update(refreshToken);
                            refreshTokenRepository.save(token);
                        },
                        () -> {
                            RefreshToken token = new RefreshToken(user.getId().longValue(), refreshToken);
                            refreshTokenRepository.save(token);
                        }
                );

        return new LoginResponse(accessToken, refreshToken);
    }
}
