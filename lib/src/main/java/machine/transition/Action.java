package machine.transition;

import machine.State;

public class Action {
    private char write;
    private Direction direction;
    private State next;
    private boolean reachedFinal;

    public Action(char write, Direction direction, State next, boolean reachedFinal) {
        this.write = write;
        this.direction = direction;
        this.next = next;
        this.reachedFinal = reachedFinal;
    }

    public char getWrite() {
        return this.write;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public State getNext() {
        return this.next;
    }

    public boolean getReachedFinal() {
        return this.reachedFinal;
    }
}
