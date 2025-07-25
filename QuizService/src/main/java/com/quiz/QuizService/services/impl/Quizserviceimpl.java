package com.quiz.QuizService.services.impl;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repository.QuizRepository;
import com.quiz.QuizService.services.QuestionClient;
import com.quiz.QuizService.services.Quizservice;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class Quizserviceimpl implements Quizservice {

    private QuizRepository quizRepository;
    private QuestionClient questionClient;

    public Quizserviceimpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public Quiz getQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestionList(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }

    public List<Quiz> get() {
        List<Quiz> quizList = new ArrayList<>();
        quizList = quizRepository.findAll();
        List<Quiz> newquizList = quizList.stream().map(
                iter -> {
                    iter.setQuestionList(questionClient.getQuestionsOfQuiz(iter.getId()));
                    return iter;
                }).collect(Collectors.toList());
        return quizList;
    }


}
