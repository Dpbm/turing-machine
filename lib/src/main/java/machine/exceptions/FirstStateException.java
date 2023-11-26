package machine.exceptions;

public class FirstStateException extends Exception {
    public FirstStateException() {
        super("No first state was found!");
    }
}
