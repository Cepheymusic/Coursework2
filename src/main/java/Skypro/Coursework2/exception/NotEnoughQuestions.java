package Skypro.Coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST) //, reason = "Not questions is collection")
public class NotEnoughQuestions extends RuntimeException{
    public NotEnoughQuestions(String massage) {
        super(massage);
    }
}
