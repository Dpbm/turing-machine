package machine;

import org.junit.Test;

import machine.exceptions.TransitionNotFound;
import machine.transition.Action;
import machine.transition.Direction;

import static org.junit.Assert.*;

public class StateTest {
    private String id = "q0";
    private State state = new State(this.id);

    @Test
    public void StateGetId() {
        assertEquals(this.id, state.getId());
    }

    @Test
    public void StateFalseFirstState() {
        assertEquals(false, state.isFirst());
    }

    @Test
    public void StateFalseFinalState() {
        assertEquals(false, state.isFinal());
    }

    @Test
    public void StateTrueFirstState() {
        state.setFirst();
        assertEquals(true, state.isFirst());
    }

    @Test
    public void StateTrueFinalState() {
        state.setFinal();
        assertEquals(true, state.isFinal());
    }

    @Test
    public void StateTestMethod() {
        char symbol = '1';
        char write = 'x';
        Direction direction = Direction.RIGHT;
        Transition transiton = new Transition(symbol, write, direction, this.state);
        this.state.addTransiton(transiton);

        try {
            Action test = this.state.test(symbol);
            assertEquals(write, test.getWrite());
            assertEquals(direction, test.getDirection());
            assertEquals(false, test.getReachedFinal());
            assertEquals(this.id, test.getNext().getId());
        } catch (TransitionNotFound error) {
            fail("Shouldn't throw an error!");
        }
    }

    @Test
    public void StateTestMethodRaiseError() {
        char symbol = '2';
        Transition transiton = new Transition('1', 'x', Direction.RIGHT, this.state);

        this.state.addTransiton(transiton);

        assertThrows(TransitionNotFound.class, () -> this.state.test(symbol));
    }

}
