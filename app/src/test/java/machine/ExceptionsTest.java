package machine;

import org.junit.Test;

import machine.exceptions.FirstStateException;
import machine.exceptions.InvalidTape;
import machine.exceptions.TransitionNotFound;

import static org.junit.Assert.*;

public class ExceptionsTest {
    @Test
    public void FirstStateExceptionCorrectMessage() {
        try {
            throw new FirstStateException();
        } catch (FirstStateException erorr) {
            assertEquals(erorr.getMessage(), "No first state was found!");
        }
    }

    @Test
    public void TransitionNotFoundCorrectMessage() {
        String state = "q0";
        char symbol = '1';
        String expectedMessage = "No transition was found in " + state + " for " + symbol;

        try {
            throw new TransitionNotFound(state, symbol);
        } catch (TransitionNotFound erorr) {
            assertEquals(erorr.getMessage(), expectedMessage);
        }
    }

    @Test
    public void InvalidTapeCorrectMessage() {
        try {
            throw new InvalidTape();
        } catch (InvalidTape erorr) {
            assertEquals(erorr.getMessage(), "The tape must have, at least, 1 symbol!");
        }
    }
}
