package com.gkaimakas.statemachine;

import java.util.ArrayList;

/**
 * Created by gkaimakas on 10/27/15.
 */
public class State<T> {
    private static int INSTANCES = 0;

    public static <T> State<T> newInstance(String name){
        return new State<T>(name);
    }

    private final int id;
    private final String name;
    private ArrayList<Stimulus<T>> stimuli = new ArrayList<>();

    public State(String name) {
        this.name = name;
        this.id = INSTANCES++;
    }

    public String getName() {
        return name;
    }

    public State addStimulus(Stimulus stimulus){
        stimuli.add(stimulus);
        return this;
    }

    public State stimulate(T value){
        for (Stimulus stimulus: stimuli){
            if (stimulus.stimulate(value)){
                return stimulus.getNextState();
            }
        }
        return null;
    }
}
