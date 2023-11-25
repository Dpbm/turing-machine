package machine.exceptions;

public class FirstStateException extends Throwable {
    public FirstStateException() {
        super("No first state was found!");
    }
}
