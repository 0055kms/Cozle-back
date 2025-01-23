package org.example.cozlebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class AccessTokenResponse {
    private String accessToken;
}