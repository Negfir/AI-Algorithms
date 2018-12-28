package Algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import Problems.State;
import Problems.Problem;
import Problems.Action;

public class Evaluate {
    State state;
    ArrayList<Action> actionSequence;

    int cost = 0;

    public int getCost(){ return cost; }
    public void setCost(int c) { cost = c; }

    public static Comparator<Evaluate> costComparator = new Comparator<Evaluate>(){

        public int compare(Evaluate c1, Evaluate c2) {
            return (int) (c1.getCost() - c2.getCost());
        }
    };
}



