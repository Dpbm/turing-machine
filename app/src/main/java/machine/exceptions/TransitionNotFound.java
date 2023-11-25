package machine.exceptions;

public class TransitionNotFound extends Throwable {
    public TransitionNotFound() {
        super("No transition was found for this symbol!");
    }
}
