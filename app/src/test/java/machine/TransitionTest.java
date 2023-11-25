package machine;

import org.junit.Test;

import machine.transition.Direction;

import static org.junit.Assert.*;

public class TransitionTest {
    private char read = '1';
    private char write = '2';
    private Direction direction = Direction.LEFT;
    private State next = new State("q0");
    private Transition transition = new Transition(this.read, this.write, this.direction, this.next);

    @Test
    public void TransitionGetReadSymbol() {
        assertEquals(this.read, transition.getReadSymbol());
    }

    @Test
    public void TransitionGetAction() {
        assertEquals(this.write, transition.getAction().getWrite());
        assertEquals(this.direction, transition.getAction().getDirection());
        assertEquals(this.next.getId(), transition.getAction().getNext().getId());
        assertEquals(false, transition.getAction().getReachedFinal());
    }

}
