package machine;

import machine.exceptions.FirstStateException;
import machine.messages.Success;
import machine.transition.Direction;

public class App {
    public static void main(String[] args) {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        State q4 = new State("q4");
        State q5 = new State("q5");

        q0.setFirst();
        q5.setFinal();

        Transition t1 = new Transition('&', '&', Direction.RIGHT, q1);
        Transition t2 = new Transition('a', 'a', Direction.LEFT, q0);
        Transition t3 = new Transition('A', 'A', Direction.LEFT, q0);
        Transition t4 = new Transition('B', 'B', Direction.LEFT, q0);
        q0.addTransiton(t1);
        q0.addTransiton(t2);
        q0.addTransiton(t3);
        q0.addTransiton(t4);

        Transition t5 = new Transition('A', 'A', Direction.RIGHT, q1);
        Transition t6 = new Transition('a', 'A', Direction.RIGHT, q2);
        Transition t7 = new Transition('B', 'B', Direction.RIGHT, q4);
        q1.addTransiton(t5);
        q1.addTransiton(t6);
        q1.addTransiton(t7);

        Transition t8 = new Transition('a', 'a', Direction.RIGHT, q2);
        Transition t9 = new Transition('B', 'B', Direction.RIGHT, q2);
        Transition t10 = new Transition('b', 'B', Direction.LEFT, q3);
        q2.addTransiton(t8);
        q2.addTransiton(t9);
        q2.addTransiton(t10);

        Transition t11 = new Transition('a', 'a', Direction.LEFT, q0);
        Transition t12 = new Transition('A', 'A', Direction.LEFT, q0);
        Transition t13 = new Transition('B', 'B', Direction.LEFT, q0);
        q3.addTransiton(t11);
        q3.addTransiton(t12);
        q3.addTransiton(t13);

        Transition t14 = new Transition('B', 'B', Direction.RIGHT, q4);
        Transition t15 = new Transition('n', 'V', Direction.RIGHT, q0);
        q4.addTransiton(t14);
        q4.addTransiton(t15);

        State[] states = { q0, q1, q2, q3, q4, q5 };

        Automaton automaton = null;

        try {
            automaton = new Automaton(states, "&aaaabbbbbn");

        } catch (FirstStateException error) {
            System.out.println(error.getMessage());
            System.exit(1);
        }

        try {
            automaton.test();
        } catch (Success sucess) {
            System.out.println(sucess.getMessage());
        } catch (Exception error) {
            System.out.println("Not accepted sequence!");
            System.out.println("Error: " + error.getMessage());
        }

        System.out.println("Final tape: " + automaton.getTape());

    }
}
