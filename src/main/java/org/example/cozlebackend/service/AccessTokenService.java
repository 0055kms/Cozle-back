package org.example.cozlebackend.service;

import lombok.RequiredArgsConstructor;
import org.example.cozlebackend.entity.User;
import org.example.cozlebackend.jwt.JwtTokenProvider;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class AccessTokenService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createAccessToken(String refreshToken) {
        if (!jwtTokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("리프레시 토큰이 유효하지 않습니다");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);
        return jwtTokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
