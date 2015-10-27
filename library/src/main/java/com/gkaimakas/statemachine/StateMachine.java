package com.gkaimakas.statemachine;

import java.util.ArrayList;

/**
 * Created by gkaimakas on 10/27/15.
 */
public class StateMachine<T> {
    public interface StateListener<T>{
        void onStateChange(State<T> previousState, State<T> newState, StateMachine<T> stateMachine);
    }

    private ArrayList<State<T>> states = new ArrayList<>();
    private State currentState;
    private ArrayList<StateListener<T>> stateListeners = new ArrayList<>();

    public StateMachine(State initialState) {
        this.currentState = initialState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public StateMachine<T> addStateListener(StateListener<T> listener){
        stateListeners.add(listener);
        return this;
    }

    public void stimulate(T value){
        State<T> nextState = getCurrentState().stimulate(value);
        if (nextState != null){
            State previousState = currentState;
            currentState = nextState;

            for (StateListener<T> listener: stateListeners){
                listener.onStateChange(previousState, currentState, this);
            }
        }
    }
}
