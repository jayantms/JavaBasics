package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    public Question createQuestion(Question question);

    public List<Question> getQuestions();

    public Question getQuestion(Long id);

    public List<Question> getQuestionsByQuizId(Long id);
}
