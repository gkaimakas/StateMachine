package com.gkaimakas.statemachine;

/**
 * Created by gkaimakas on 10/27/15.
 */
public class Stimulus<T> {
    public static <T> Stimulus<T> newInstance(State nextState, T value){
        return new Stimulus<T>(nextState, value);
    }

    private final State nextState;
    private final T value;

    public Stimulus(State nextState, T value) {
        this.nextState = nextState;
        this.value = value;
    }

    public State getNextState() {
        return nextState;
    }

    public T getValue(){
        return value;
    }

    public boolean stimulate(T value){
        return getValue().equals(value);
    }
}
