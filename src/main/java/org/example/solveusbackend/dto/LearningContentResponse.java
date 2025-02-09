package org.example.solveusbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LearningContentResponse {
    private Integer id;
    private String title;
    private String body;
}
