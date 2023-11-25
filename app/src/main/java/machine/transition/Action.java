package machine.transition;

import machine.State;

public class Action {
    private char write;
    private Direction direction;
    private State next;

    public Action(char write, Direction direction, State next) {
        this.write = write;
        this.direction = direction;
        this.next = next;
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
}
