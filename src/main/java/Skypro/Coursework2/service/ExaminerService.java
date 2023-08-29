package Skypro.Coursework2.service;

import Skypro.Coursework2.dto.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
