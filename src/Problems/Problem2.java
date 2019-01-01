package Problems;


import Problems.Action;
import Problems.Problem;
import Problems.State;
import Problems.State2;

import java.util.ArrayList;

public class Problem2 implements Problem {

    private int[][] init;
    public static int node;
    public Problem2(int[][] init){
        this.init = init;
        node=0;
    }

    @Override
    public State initialState() {
        return new State2(init);
    }

    @Override
    public ArrayList<Action> actions(State s) {
        State2 eps = (State2)s;
        ArrayList<Action> acts = new ArrayList<>();
        //find index of 0
        int i0 = -1 ,j0 = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(eps.P[i][j] == 0){
                    i0 = i;
                    j0 = j;
                }
            }
        }
        if(i0 == -1 || j0 == -1) return null;

        //0 : Move Left
        //1 : Move Up
        //2 : Move Right
        //3 : Move Down

        //Move Left
        if(j0 > 0) acts.add(new Action(0,"left"));

        //Move Up
        if(i0 > 0) acts.add(new Action(1,"up"));

        //Move Right
        if(j0 < 2) acts.add(new Action(2,"right"));

        //Move Down
        if(i0 < 2) acts.add(new Action(3,"down"));

        return acts;
    }

    @Override
    public ArrayList<State> result(State s, Action a) {
        State2 eps = (State2)s;
        State2 newstate = eps.clone();

        //find index of 0
        int i0 = -1 ,j0 = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(eps.P[i][j] == 0){
                    i0 = i;
                    j0 = j;
                }
            }
        }
        if(i0 == -1 || j0 == -1) return null;



        switch(a.actionType){
            case 0:
                newstate.P[i0][j0] = eps.P[i0][j0-1];
                newstate.P[i0][j0-1] = 0;

                break;

            case 1:
                newstate.P[i0][j0] = eps.P[i0-1][j0];
                newstate.P[i0-1][j0] = 0;
                break;

            case 2:
                newstate.P[i0][j0] = eps.P[i0][j0+1];
                newstate.P[i0][j0+1] = 0;
                break;

            case 3:
                newstate.P[i0][j0] = eps.P[i0+1][j0];
                newstate.P[i0+1][j0] = 0;
                break;
        }

        ArrayList<State> nextState = new ArrayList<>();
        nextState.add(newstate);
        return nextState;
    }

    @Override
    public int getNode(){
        return node;
    }

    @Override
    public boolean goalTest(State s) {
        State2 eps = (State2)s;
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (eps.P[i][j] != n) return false;
                n++;
            }
        }
        return true;
    }

    @Override
    public int utility(Action a) {
        return 1;
    }

    @Override
    public int heuristic(State s) {
        State2 eps = (State2)s;
        int h = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = eps.P[i][j];
                int ti = val / 3;
                int tj = val % 3;
                h += Math.abs(i - ti) + Math.abs(j - tj);
            }
        }
        return h;
    }

    @Override
    public boolean goalTestBi(State s1,State s2) {

        return true;}

    @Override
    public ArrayList<Action> actionsBd(State s) {


        ArrayList<Action> nextState = new ArrayList<>();

        return nextState;
    }
    @Override
    public ArrayList<State> resultBd(State s, Action a) {


        ArrayList<State> nextState = new ArrayList<>();

        return nextState;
    }

@Override
public State goalState() {
    return new State2(init);
}

}

