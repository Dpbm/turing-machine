package machine;

import java.util.ArrayList;

import machine.exceptions.TransitionNotFound;
import machine.transition.Action;

public class State {
    private String id;
    private boolean firstState = false;
    private boolean finalState = false;
    private ArrayList<Transition> transitions = new ArrayList<Transition>();

    public State(String id) {
        this.id = id;
    }

    public State(String id, ArrayList<Transition> transitions) {
        this.id = id;
        this.transitions = transitions;
    }

    public State(String id, ArrayList<Transition> transitions, boolean firstState, boolean finalState) {
        this.id = id;
        this.transitions = transitions;
        this.firstState = firstState;
        this.finalState = finalState;
    }

    public void addTransiton(Transition transition) {
        transitions.add(transition);
    }

    public void setFinal() {
        this.finalState = true;
    }

    public boolean isFinal() {
        return this.finalState;
    }

    public void setFirst() {
        this.firstState = true;
    }

    public boolean isFirst() {
        return this.firstState;
    }

    public String getId() {
        return this.id;
    }

    private Transition getTransitionForSymbol(char symbol) throws TransitionNotFound {
        for (Transition transition : this.transitions)
            if (transition.getReadSymbol() == symbol)
                return transition;

        throw new TransitionNotFound();
    }

    public Action test(char symbol) throws TransitionNotFound {
        Transition nextTransition = this.getTransitionForSymbol(symbol);
        return nextTransition.getAction();
    }

}
