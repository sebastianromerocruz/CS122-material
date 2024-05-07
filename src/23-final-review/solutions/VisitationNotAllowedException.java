/**
 * Represents an exception that is thrown when a visitation is not allowed.
 * This exception is thrown when a visitor tries to visit a location that is 
 * not allowed to be visited. 
 * This exception is a checked exception, which means that it must be either
 * caught or declared to be thrown.
 */
class VisitationNotAllowedException extends Exception {
    /**
     * Constructs a new VisitationNotAllowedException with the specified detail message.
     * @param message the detail message
     */
    public VisitationNotAllowedException(String message) {
        super(message);
    }
}