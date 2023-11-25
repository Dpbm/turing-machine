package machine;

import machine.transition.Action;
import machine.transition.Direction;

public class Transition {
    private char read;
    private Action action;
    private State next;

    public Transition(char read, char write, Direction direction, State next) {
        this.read = read;
        this.next = next;
        this.action = new Action(write, direction);
    }

    public char getReadSymbol() {
        return this.read;
    }

    public Action getAction() {
        return this.action;
    }

    public State getNextState() {
        return this.next;
    }
}
