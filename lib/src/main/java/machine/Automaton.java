package machine;

import machine.exceptions.FirstStateException;
import machine.exceptions.InvalidTape;
import machine.exceptions.TransitionNotFound;
import machine.transition.Action;
import machine.transition.Direction;

public class Automaton {
    private State[] states;
    private char[] tape;
    private State firstState;

    private int symbolIndex = 0;
    private char actualSymbol;

    private State actualState;

    public Automaton(State[] states, String tape) throws FirstStateException, InvalidTape {
        this.states = states;
        this.tape = tape.toCharArray();

        if (this.tape.length == 0)
            throw new InvalidTape();

        this.actualSymbol = this.tape[this.symbolIndex];
        this.getFirstState();
        this.actualState = this.firstState;
    }

    private void getFirstState() throws FirstStateException {
        for (State state : this.states) {
            if (state.isFirst()) {
                this.firstState = state;
                return;
            }
        }

        throw new FirstStateException();
    }

    private void move(Direction direction) {
        if (direction == Direction.LEFT)
            this.moveLeft();
        else
            this.moveRight();
    }

    private void moveRight() {
        this.symbolIndex++;
    }

    private void moveLeft() {
        this.symbolIndex--;
    }

    private void updateActualSymbol() throws ArrayIndexOutOfBoundsException {
        this.actualSymbol = this.tape[this.symbolIndex];
    }

    public boolean test() throws TransitionNotFound {
        while (true) {
            Action transitionResult = this.makeTransition();
            this.actualState = transitionResult.getNext();
            this.write(transitionResult.getWrite());
            this.move(transitionResult.getDirection());

            try {
                this.updateActualSymbol();
            } catch (ArrayIndexOutOfBoundsException error) {
                return transitionResult.getReachedFinal();
            }
        }

    }

    private Action makeTransition() throws TransitionNotFound {
        return this.actualState.test(this.actualSymbol);
    }

    private void write(char newSymbol) throws ArrayIndexOutOfBoundsException {
        this.tape[this.symbolIndex] = newSymbol;
    }

    public String getTape() {
        return new String(this.tape);
    }
}
