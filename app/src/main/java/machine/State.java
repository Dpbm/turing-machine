package machine;

public class State {
    private String id;
    private boolean firstState = false;
    private boolean finalState = false;
    private Transitions[] transitions;

    public State(String id, Transitions[] transitions) {
        this.id = id;
        this.transitions = transitions;
    }

    public State(String id, Transitions[] transitions, boolean firstState) {
        this.id = id;
        this.transitions = transitions;
        this.firstState = firstState;
    }

    public State(String id, Transitions[] transitions, boolean finalState) {
        this.id = id;
        this.transitions = transitions;
        this.finalState = finalState;
    }

    public State(String id, Transitions[] transitions, boolean firstState, boolean finalState) {
        this.id = id;
        this.transitions = transitions;
        this.firstState = firstState;
        this.finalState = finalState;
    }

}
