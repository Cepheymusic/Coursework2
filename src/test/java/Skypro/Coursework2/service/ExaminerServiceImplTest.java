package Skypro.Coursework2.service;

import Skypro.Coursework2.dto.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl underTest;
    Question question1 = new Question("w", "q");
    Question question2 = new Question("d", "g");
    @Test
    void getQuestions_enoughQuestionsInList_setOfQuestionsReturned() {
        int amount = 2;
        when(questionService.getAll()).thenReturn(Set.of(question1, question2));
        Collection<Question> result = underTest.getQuestions(amount);

        assertEquals(amount, result.size());
        assertEquals(amount, result.stream().distinct().count());
    }
}