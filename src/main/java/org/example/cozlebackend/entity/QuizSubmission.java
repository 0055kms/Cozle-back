package org.example.cozlebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "quiz_submission")
public class QuizSubmission {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Lob
    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect = false;

    @ColumnDefault("0")
    @Column(name = "earned_exp")
    private Integer earnedExp;

    @ColumnDefault("0")
    @Column(name = "earned_coin")
    private Integer earnedCoin;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}