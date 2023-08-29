package Skypro.Coursework2.service;

import Skypro.Coursework2.dto.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class javaQuestionServiceTest {
    javaQuestionService underTest = new javaQuestionService();

    Question question1 = new Question("w", "q");
    Question question2 = new Question("d", "g");

    @Test
    void add__questionAddedAndReturn() {
        Question result = underTest
    }

}