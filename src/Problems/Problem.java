package Problems;

import java.util.ArrayList;


public interface Problem {


int getNode();

    State initialState();

    ArrayList<Action> actions(State s);

    ArrayList<State> result(State s,Action a);

    boolean goalTest(State s);

    int utility(Action a);

    int heuristic(State s);

//    int Depth();
//    int Depth();

    State goalState();

    ArrayList<Action> actionsBd(State s);

    ArrayList<State> resultBd(State s,Action a);

    boolean goalTestBi(State s1,State s2);

//
//    ArrayList<Action> actionsBd(State s);
//
//    ArrayList<State> resultBd(State s,Action a);

}
