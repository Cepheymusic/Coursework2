package Skypro.Coursework2.service;

import Skypro.Coursework2.dto.Question;
import Skypro.Coursework2.exception.NotEnoughQuestions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl underTest;
    Question question = new Question("r", "y");
    Question question1 = new Question("w", "q");
    Question question2 = new Question("d", "g");
    Collection<Question> questions = new HashSet<>(Set.of(question, question1,question2));
    @Test
    void getQuestions_enoughQuestionsInList_setOfQuestionsReturned() {
        int amount = 2;
        when(questionService.getAll()).thenReturn(Set.of(question1, question2));
        Collection<Question> result = underTest.getQuestions(amount);

        assertEquals(amount, result.size());
        assertEquals(amount, result.stream().distinct().count());
    }
    @Test
    void getQuestions_enoughQuestionsNotInList_setWithoutQuestionsReturned() {
        int amount = 2;
        when(questionService.getAll()).thenReturn(Set.of(question));
        NotEnoughQuestions result =
                assertThrows(NotEnoughQuestions.class, () -> underTest.getQuestions(amount));
        assertEquals("Not questions is collection", result.getMessage());
    }
    @Test
    void getQuestion_getRandomQuestions_questionsReturn() {
        int amount = 2;
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(question, question1, question2);
        Collection<Question> result = underTest.getQuestions(amount);
        assertTrue(result.containsAll(Set.of(question, question1)));
    }
}