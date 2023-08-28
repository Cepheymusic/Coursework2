package Skypro.Coursework2.service;

import Skypro.Coursework2.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
