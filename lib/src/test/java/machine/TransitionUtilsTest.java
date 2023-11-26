package machine;

import org.junit.Test;

import machine.transition.Action;
import machine.transition.Direction;

import static org.junit.Assert.*;

public class TransitionUtilsTest {
    private char write = 'w';
    private Direction direction = Direction.LEFT;
    private State next = null;
    private boolean reachedFinal = true;
    private Action defaultAction = new Action(this.write, this.direction, this.next, this.reachedFinal);

    @Test
    public void ActionEqualWriteSymbol() {
        assertEquals(this.write, defaultAction.getWrite());
    }

    @Test
    public void ActionEqualDirection() {
        assertEquals(this.direction, defaultAction.getDirection());
    }

    @Test
    public void ActionEqualNextState() {
        assertEquals(this.next, defaultAction.getNext());
    }

    @Test
    public void ActionEqualReachedFinal() {
        assertEquals(this.reachedFinal, defaultAction.getReachedFinal());
    }
}
