package Algorithms;
import Problems.Problem;
import Problems.State;
public abstract class Algorithm {

    public Problem problem;
    public int exploredCnt;
    public int frontierCnt;
    public int memUsage;

    public Algorithm(Problem problem){
        this.problem = problem;
        exploredCnt = 0;
        frontierCnt = 0;
        memUsage = 0;
    }

    //public abstract void run();

   // public abstract State getNextState();
}
