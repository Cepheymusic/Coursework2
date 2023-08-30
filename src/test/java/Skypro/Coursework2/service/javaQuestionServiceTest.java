package Skypro.Coursework2.service;

import Skypro.Coursework2.dto.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class javaQuestionServiceTest {
    javaQuestionService underTest = new javaQuestionService();

    Question question1 = new Question("w", "q");
    Question question2 = new Question("d", "g");

    @Test
    void add__questionAddedAndReturn() {
        Question result = underTest.add(question1.getQuestion(), question1.getAnswer());
        assertEquals(question1, result);
        assertTrue(underTest.getAll().contains(question1));

    }

    @Test
    void remove__questionRemoveAndReturn() {
       underTest.add(question1.getQuestion(), question1.getAnswer());
        Question result = underTest.remove(question1);
        assertEquals(question1, result);
        assertFalse(underTest.getAll().contains(question1));
    }

    @Test
    void getAll_questionsAreInSet_setWithQuestionReturned() {
        underTest.add(question1);
        underTest.add(question2);
        Collection<Question> result = underTest.getAll();
        assertTrue(result.containsAll(Set.of(question1, question2)));
    }
    @Test
    void getAll_questionsAreNotInSet_setWithoutQuestionReturned() {
        Collection<Question> result = underTest.getAll();
        assertFalse(result.containsAll(Set.of(question1, question2)));
    }

    @Test
    void getRandomQuestion_questionInSet_questionReturn() {
        underTest.add(question1);
        Question result = underTest.getRandomQuestion();
        assertEquals(question1, result);
    }
}