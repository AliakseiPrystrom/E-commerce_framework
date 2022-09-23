package exceptions;

public class CustomException extends RuntimeException {

    public CustomException(String errMessage) {
        super(errMessage);
    }
}
