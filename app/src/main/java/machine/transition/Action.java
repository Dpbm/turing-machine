package machine.transition;

public class Action {
    private char write;
    private Direction direction;

    public Action(char write, Direction direction) {
        this.write = write;
        this.direction = direction;
    }

    public char getWrite() {
        return this.write;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
