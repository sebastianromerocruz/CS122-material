package exceptions;

public class StandardDeviationNotCalculableException extends NullPointerException {
    public StandardDeviationNotCalculableException(String message) {
        super(message);
    }
}
