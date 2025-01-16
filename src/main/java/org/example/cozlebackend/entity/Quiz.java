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
@Table(name = "quiz")
public class Quiz {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "content_id", nullable = false)
    private LearningContent content;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "quiz_type", nullable = false)
    private Integer quizType;

    @Column(name = "difficulty", nullable = false)
    private Integer difficulty;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}