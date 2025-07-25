package com.quiz.QuizService.services;

import com.quiz.QuizService.entities.Quiz;

import java.util.List;

public interface Quizservice {

    public void save(Quiz quiz);
    public Quiz getQuiz(Long id);
    public List<Quiz> get();
}
