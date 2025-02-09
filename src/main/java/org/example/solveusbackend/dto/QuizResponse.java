package org.example.solveusbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuizResponse {
    private Integer id;
    private String title;
    private String question;
    private Integer quizType;
    private Integer difficulty;
    private List<QuizOptionResponse> options;
}
