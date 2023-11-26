package machine;

import org.junit.Test;

import machine.messages.Success;

import static org.junit.Assert.*;

public class MessagesTest {
    @Test
    public void SucessCorrectMessage() {
        try {
            throw new Success();
        } catch (Success success) {
            assertEquals(success.getMessage(), "Accepted sequence!");
        }
    }
}
