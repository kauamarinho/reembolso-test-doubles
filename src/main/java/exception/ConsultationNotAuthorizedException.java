package exception;

public class ConsultationNotAuthorizedException extends RuntimeException {

    public ConsultationNotAuthorizedException(String message) {
        super(message);
    }
}
