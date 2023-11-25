package machine.exceptions;

public class TransitionNotFound extends Exception {
    public TransitionNotFound(String state, char symbol) {
        super("No transition was found in " + state + " for " + symbol);
    }
}
