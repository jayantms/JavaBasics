package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @GetMapping
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuotation(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getQuotationByQuiz(@PathVariable Long id) {
        return questionService.getQuestionsByQuizId(id);
    }

}
