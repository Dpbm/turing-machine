package machine;

import machine.transition.Action;
import machine.transition.Direction;

public class Transition {
    private char read;
    private Action action;

    public Transition(char read, char write, Direction direction, State next) {
        this.read = read;
        this.action = new Action(write, direction, next, next.isFinal());
    }

    public char getReadSymbol() {
        return this.read;
    }

    public Action getAction() {
        return this.action;
    }
}
