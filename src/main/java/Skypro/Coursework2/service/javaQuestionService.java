package Skypro.Coursework2.service;

import Skypro.Coursework2.dto.Question;
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
        return add(new Question(question, answer));
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
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(rmd.nextInt(questions.size()));
    }
}
