package com.quiz.QuizService.Controller;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.Quizservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Quizcontroller {

    private Quizservice quizservice;

    public Quizcontroller(Quizservice quizservice) {
        this.quizservice = quizservice;
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        quizservice.save(quiz);
        return quiz;
    }

    @GetMapping
    public List<Quiz> getQuiz() {
        return quizservice.get();
    }

    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        return quizservice.getQuiz(id);
    }

}
