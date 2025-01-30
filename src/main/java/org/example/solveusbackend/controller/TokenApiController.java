package org.example.solveusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.solveusbackend.dto.AccessTokenRequest;
import org.example.solveusbackend.dto.AccessTokenResponse;
import org.example.solveusbackend.service.AccessTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
    private final AccessTokenService accessTokenService;

    @PostMapping("/api/token")
    public ResponseEntity<AccessTokenResponse> createNewAccessToken(@RequestBody AccessTokenRequest accessTokenRequest) {
        String newAccessToken = accessTokenService.createAccessToken(accessTokenRequest.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AccessTokenResponse(newAccessToken));
    }
}
