package Skypro.Coursework2.controller;

import Skypro.Coursework2.dto.Question;
import Skypro.Coursework2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/java")
@RestController
public class JavaQuestionController {
    public QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }
    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return questionService.remove(question1);
    }
    @GetMapping
    public Collection<Question> getAllQuestion() {
        return questionService.getAll();
    }
}
