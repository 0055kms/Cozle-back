package org.example.solveusbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitQuizRequest {
    private Integer quizId;
    private String userAnswer;

}
