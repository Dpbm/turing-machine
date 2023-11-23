package machine;

public class Automaton {
    private State[] states;
    private char[] tape;

    public Automaton(State[] states, String tape) {
        this.states = states;
        this.tape = tape.toCharArray();
    }
}
