package machine;

import org.junit.Test;

import machine.exceptions.FirstStateException;
import machine.exceptions.InvalidTape;
import machine.exceptions.TransitionNotFound;
import machine.messages.Success;
import machine.transition.Direction;

import static org.junit.Assert.*;

public class AutomatonTest {
    private String tape = "1";

    @Test
    public void AutomatonInvalidTape() {
        assertThrows(InvalidTape.class, () -> new Automaton(new State[1], ""));
    }

    @Test
    public void AutomatonNoFirstStateError() {
        State q0 = new State("q0");
        State[] states = { q0 };
        assertThrows(FirstStateException.class, () -> new Automaton(states, this.tape));
    }

    @Test
    public void AutomatonGetTape() {
        try {
            State q0 = new State("q0");
            q0.setFirst();
            State[] states = { q0 };
            Automaton automaton = new Automaton(states, this.tape);
            assertEquals(this.tape, automaton.getTape());
        } catch (Exception error) {
            fail("this one shoudn't throw an error!");
        }
    }

    @Test
    public void AutomatonTestSuccess() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        q0.setFirst();
        q1.setFinal();

        Transition t = new Transition('1', 'x', Direction.RIGHT, q1);
        q0.addTransiton(t);

        State[] states = { q0, q1 };

        assertThrows(Success.class, () -> (new Automaton(states, this.tape)).test());
    }

    @Test
    public void AutomatonTestArrayIndexOutOfBounds() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        q0.setFirst();
        q2.setFinal();

        Transition t1 = new Transition('1', 'x', Direction.RIGHT, q1);
        Transition t2 = new Transition('1', 'x', Direction.RIGHT, q2);
        q0.addTransiton(t1);
        q1.addTransiton(t2);

        State[] states = { q0, q1, q2 };

        assertThrows(IndexOutOfBoundsException.class, () -> (new Automaton(states, this.tape)).test());
    }

    @Test
    public void AutomatonTestTransitionNotFound() {
        State q0 = new State("q0");
        q0.setFirst();

        Transition t = new Transition('2', 'x', Direction.RIGHT, q0);
        q0.addTransiton(t);

        State[] states = { q0 };

        assertThrows(TransitionNotFound.class, () -> (new Automaton(states, this.tape)).test());
    }

}
