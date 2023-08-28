package Skypro.Coursework2.service;

import Skypro.Coursework2.Question;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class javaQuestionService implements QuestionService {
    private final Set<Question> questions;
    private final Random rmd = new Random();

    public javaQuestionService() {
        this.questions = new HashSet<>();
    }
    @Override
    public Question add(String question, String answer) {
        var result = new Question(question, answer);
        questions.add(result);
        return result;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;  // как метод вернёт всех их хэшсет?
    }

    @Override
    public Question getRandomQuestion() {
        int index = rmd.nextInt(questions.size());
        Iterator<Question> iter = questions.iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
    }
}
