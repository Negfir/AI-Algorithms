package Problems;

import java.util.ArrayList;


public interface Problem {




    State initialState();

    ArrayList<Action> actions(State s);

    ArrayList<State> result(State s,Action a);

    boolean goalTest(State s);

    int utility(Action a);

    int heuristic(State s);

    State goalState();
//
//    ArrayList<Action> actionsBd(State s);
//
//    ArrayList<State> resultBd(State s,Action a);

}
