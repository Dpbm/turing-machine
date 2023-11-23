package machine;

public class State {
    private String id;
    private boolean firstState = false;
    private boolean finalState = false;
    private Transition[] transitions;

    public State(String id, Transition[] transitions) {
        this.id = id;
        this.transitions = transitions;
    }

    public State(String id, Transition[] transitions, boolean firstState, boolean finalState) {
        this.id = id;
        this.transitions = transitions;
        this.firstState = firstState;
        this.finalState = finalState;
    }

}
