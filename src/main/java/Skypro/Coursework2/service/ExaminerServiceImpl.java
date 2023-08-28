package Skypro.Coursework2.service;

import Skypro.Coursework2.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }

}
