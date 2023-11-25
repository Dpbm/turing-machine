package machine;

import machine.transition.Direction;

public class App {
    public static void main(String[] args) {
        State[] states = new State[2];

        State q0 = new State("q0");
        q0.setFirst();

        State q1 = new State("q1");
        q1.setFinal();

        Transition t1 = new Transition('1', 'x', Direction.RIGHT, q1);
        q0.addTransiton(t1);

        states[0] = q0;
        states[1] = q1;

        Automaton automaton = new Automaton(states, "1");

    }
}
