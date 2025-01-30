package org.example.solveusbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessTokenRequest {
    private String refreshToken;
}
