package gr.qualco.demo.countrystats.exception;

public class InvalidYearRangeException extends RuntimeException {
    public InvalidYearRangeException(String message) {
        super(message);
    }
}
