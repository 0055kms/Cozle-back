package org.example.solveusbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RankingUserResponse {
    private Long userId;
    private String nickname;
    private Integer tier;
    private Integer exp;
    private Integer coin;
    private int rank;
}
