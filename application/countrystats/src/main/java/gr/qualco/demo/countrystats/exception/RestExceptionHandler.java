package gr.qualco.demo.countrystats.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(InvalidYearRangeException.class)
    public ResponseEntity<Map<String, String>> handleInvalidYearRangeException(InvalidYearRangeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Invalid Year Range");
        error.put("message", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
