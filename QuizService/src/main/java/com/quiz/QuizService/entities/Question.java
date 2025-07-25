package com.quiz.QuizService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Question {
    private Long questionId;

    private String question;

    private Long quizId;
}
