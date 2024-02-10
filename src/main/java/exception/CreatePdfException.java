package exception;

/** Runtime Exception */
public class CreatePdfException extends RuntimeException {

    public CreatePdfException(String message, Throwable cause) {
        super(message, cause);
    }
}
