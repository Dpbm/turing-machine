package machine;

import machine.exceptions.FirstStateException;
import machine.messages.Success;
import machine.transition.Direction;

public class App {
    public static void main(String[] args) {
        State[] states = new State[2];

        State q0 = new State("q0");
        q0.setFirst();
        q0.setFinal();

        State q1 = new State("q1");
        q1.setFinal();

        Transition t1 = new Transition('1', 'x', Direction.RIGHT, q1);
        q0.addTransiton(t1);

        Transition t2 = new Transition('1', 'x', Direction.LEFT, q0);
        q1.addTransiton(t2);

        Transition t3 = new Transition('x', 'o', Direction.LEFT, q0);
        q0.addTransiton(t3);

        states[0] = q0;
        states[1] = q1;
        Automaton automaton = null;

        try {
            automaton = new Automaton(states, "11");

        } catch (FirstStateException error) {
            System.out.println(error.getMessage());
            System.exit(1);
        }

        try {
            automaton.test();
        } catch (Success sucess) {
            System.out.println(sucess.getMessage());
        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }

        System.out.println("Final tape: " + automaton.getTape());

    }
}
