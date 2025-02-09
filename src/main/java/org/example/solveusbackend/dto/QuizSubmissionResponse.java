package org.example.solveusbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizSubmissionResponse {
    private Integer submissionId;
    private Integer quizId;
    private boolean isCorrect;
    private Integer earnedExp;
    private Integer earnedCoin;
    private Integer userCurrentExp;
    private Integer userCurrentCoin;
    private Integer userCurrentTier;
}
