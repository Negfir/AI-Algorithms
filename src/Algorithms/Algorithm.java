package Algorithms;

import Problems.Problem;
import Problems.State;


public abstract class Algorithm {

    public Problem problem;
    public int visitedNodesNo;
    public int expandedNodesNo;

    public Algorithm(Problem problem){
        this.problem = problem;
        visitedNodesNo = 0;
        expandedNodesNo = 0;
    }

    public abstract void run();
    public abstract State getNextState();
    public abstract void getInfo(State state);
    public abstract void trap();
}
