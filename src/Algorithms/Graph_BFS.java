package Algorithms;

import Problems.State;
import Problems.Problem;
import Problems.Action;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFS {

    LinkedList<State> frontier;
    LinkedList<State> explored;

    public Graph_BFS(Problem p){
        search(p,true);
    }

    public static ArrayList<Action> search(Problem p,boolean isGraphSearch){

        Queue<Evaluate> BFSQueue = new LinkedList<>();
        ArrayList<State> closed = new ArrayList<>();

        Evaluate initE = new Evaluate();
        initE.state = p.initialState();
        initE.actionSequence = new ArrayList<>();

        BFSQueue.add(initE);

        while(!BFSQueue.isEmpty()){
            System.out.println("[");
            Evaluate s = BFSQueue.remove();
            if(p.goalTest(s.state)){
                //Goal Reached
                System.out.println("[BFS] Goal Reached !");
                return s.actionSequence;
            }else{
                //Close Current State
                closed.add(s.state);
                //Expand Childs
                for(Action a : p.actions(s.state)){
                    System.out.println(a.actionType);
                    for(State targetState : p.result(s.state,a)) { //undeterministic states (more than 1)
                        boolean mustAdd = true;
                        if(isGraphSearch) {
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
        }
        //There is no answer to algorithm.Problem
        System.err.println("[BFS] No Answer !");
        return null;
    }


//    public Graph_BFS(Problem problem) {
//        super(problem);
//        frontier = new LinkedList<>();
//        explored = new LinkedList<>();
//        run();
//    }
//
//    @Override
//    public void run() {
//        State s = problem.initialState();
//        frontier.add(s);
//        memUsage++;
//
//        if(problem.goalTest(s)) {
//            showResult(s);
//            return;
//        }
//
//        while (!frontier.isEmpty()){
//            System.out.println("Hi");
//            s = getNextState();
//
//            frontierCnt++;
//            exploredCnt++;
//            explored.add(s);
//
//            ArrayList<Action> actions = problem.actions(s);
//
//            for (Action a:actions) {
//                State next = problem.result(s, a);
//                next.update(s);
//
//                if(problem.goalTest(next)) {
//                    showResult(next);
//                    return;
//                }
//                if (!isExist(next)) {
//                    frontier.add(next);
//                }
//            }
//            memUsage = Math.max(memUsage , frontier.size() + explored.size());
//        }
//    }
//
//    @Override
//    public State getNextState() {
//        return frontier.remove();
//    }
//
//    public void showResult(State finalState){
//        //float[] temp = problem.bestPath(finalState);
//        //System.out.println("NODE NUMBER EXIST: " + temp[0]);
//        //System.out.println("PATH COST: " + temp[1]);
//        System.out.println("MAX MEMORY USAGE: " + memUsage);
//        System.out.println("EXPANDED NODES: "+explored.size());
//        System.out.println("VISITED NODES: "+explored.size());
//    }
//
//    public boolean isExist(State next){
//        for (int i = 0; i < explored.size(); i++) {
//            State temp = explored.get(i);
//            if (temp.isEquals(next))
//                return true;
//        }
//        return false;
//    }
}
