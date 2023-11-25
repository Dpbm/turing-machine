package machine;

import machine.exceptions.FirstStateException;
import machine.exceptions.TransitionNotFound;
import machine.messages.Success;
import machine.transition.Action;
import machine.transition.Direction;

public class Automaton {
    private State[] states;
    private char[] tape;
    private State firstState;

    private int symbolIndex = 0;
    private char actualSymbol;

    private State actualState;

    public Automaton(State[] states, String tape) throws FirstStateException {
        this.states = states;
        this.tape = tape.toCharArray();
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

    public void test() throws ArrayIndexOutOfBoundsException, TransitionNotFound, Success {
        while (true) {
            Action transitionResult = this.makeTransition();
            this.actualState = transitionResult.getNext();
            this.write(transitionResult.getWrite());
            this.move(transitionResult.getDirection());

            try {
                this.updateActualSymbol();
            } catch (ArrayIndexOutOfBoundsException error) {
                if (transitionResult.getReachedFinal())
                    throw new Success();
                else
                    throw new ArrayIndexOutOfBoundsException("Reached the end of the tape");

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
