package Algorithms;

import Problems.State;
import Problems.State1;
import Problems.Problem;
import Problems.Action;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFS {

    public static int memUsage=0;
    public static int exploredCnt=0;
    public static int frontierCnt=0;
    public  Problem pr;
    public static  int depth=0;

    LinkedList<State> frontier;
    LinkedList<State> explored;
    public static Queue<Evaluate> BFSQueue = new LinkedList<>();
    public static ArrayList<State> closed = new ArrayList<>();

    public Graph_BFS(Problem p){
        pr=p;
        search(p,false);
    }

    public static ArrayList<Action> search(Problem p,boolean isGraphSearch){



        Evaluate initE = new Evaluate();
        initE.state = p.initialState();
        initE.actionSequence = new ArrayList<>();

        BFSQueue.add(initE);
        memUsage++;

        while(!BFSQueue.isEmpty()){
            exploredCnt++;
            frontierCnt++;
            System.out.println("[");
            Evaluate s = BFSQueue.remove();
            if(p.goalTest(s.state)){
                //Goal Reached
//                for (String i: ){
//                    System.out.println(i+"-k");
//                }
                showResult(s.state);
                System.out.println("[BFS] Goal Reached !");
                return s.actionSequence;
            }else{
                //Close Current State
                closed.add(s.state);
                //Expand Childs
                //depth++;
                try {
                    for (Action a : p.actions(s.state)) {

                        for (State targetState : p.result(s.state, a)) { //undeterministic states (more than 1)
                            boolean mustAdd = true;
                            if (isGraphSearch) {
                                for (State closedState : closed) {
                                    if (closedState.isEquals(targetState)) {
                                        mustAdd = false;
                                        break;
                                    }
                                }
                            }
                            for (Evaluate openState : BFSQueue) {
                                if (openState.state.isEquals(targetState)) {
                                    mustAdd = false;
                                    break;
                                }
                            }
                            if (mustAdd) {
                                Evaluate SAS = new Evaluate();
                                SAS.state = targetState;
                                System.out.println(a.actionType);

                                //Clone Parent Action Sequence
                                ArrayList<Action> asClone = new ArrayList<>();
                                for (Action sa : s.actionSequence) {
                                    asClone.add(sa);

                                }
                                asClone.add(a);
                                SAS.actionSequence = asClone;
                                BFSQueue.add(SAS);
                            }

                        }

                    }
                }
                catch (java.lang.NullPointerException exception)
                    {
// Catch NullPointerExceptions.
                        //Logging.log(exception);
                        System.out.println("Null");
                    }

            }
            memUsage = Math.max(memUsage , BFSQueue.size());
        }

        //There is no answer to algorithm.Problem
        System.err.println("[BFS] No Answer !");
        return null;
    }

    public static void showResult(State finalState){
        System.out.println("");
        //System.out.println("DEPTH: " + depth);
        System.out.println("NODES COUNT: " + (closed.size()+BFSQueue.size()));
        System.out.println("MEMORY USAGE: " + memUsage);
        System.out.println("EXPANDED NODES: "+closed.size());
        System.out.println("VISITED NODES: "+closed.size());
    }


}
