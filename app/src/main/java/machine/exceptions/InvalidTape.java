package machine.exceptions;

public class InvalidTape extends Exception {
    public InvalidTape() {
        super("The tape must have, at least, 1 symbol!");
    }
}
