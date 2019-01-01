package Algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import Problems.State;
import Problems.State1;
import Problems.Problem;
import Problems.Action;


public class UniformCost {

    public static int memUsage=0;
    public static PriorityQueue<Evaluate> UCSQueue = new PriorityQueue<>(Evaluate.costComparator);
    public static ArrayList<State> closed = new ArrayList<>();

    public static ArrayList<Action> search(Problem p){
        return search(p,true);
    }

    public static ArrayList<Action> search(Problem p,boolean isGraphSearch){



        Evaluate initE = new Evaluate();
        initE.state = p.initialState();
        initE.actionSequence = new ArrayList<>();

        UCSQueue.add(initE);
        memUsage++;

        while(!UCSQueue.isEmpty()){
            Evaluate s = UCSQueue.remove();
            if(p.goalTest(s.state)){
                //Goal Reached
                showResult(s.state);
                System.out.println("[UCS] Goal Reached !");
                return s.actionSequence;
            }else{
                //Close Current State
                closed.add(s.state);
                //Expand Childs
                for(Action a : p.actions(s.state)){
                    for(State targetState : p.result(s.state,a)) {
                        boolean mustAdd = true;
                        if(isGraphSearch){
                            for (State closedState : closed) {
                                if (closedState.isEquals(targetState)) {
                                    mustAdd = false;
                                    break;
                                }
                            }
                        }
                        for (Evaluate openState : UCSQueue) {
                            if (openState.state.isEquals(targetState)) {
                                //must update is less cost reached
                                if (s.cost + p.utility(a) < openState.getCost()) {
                                    openState.setCost(s.cost + p.utility(a));
                                }
                                //no need to add it again
                                mustAdd = false;
                                break;
                            }
                        }
                        if (mustAdd) {
                            Evaluate E = new Evaluate();
                            E.state = targetState;
                            //Clone Parent Action Sequence
                            ArrayList<Action> asClone = new ArrayList<>();
                            for (Action sa : s.actionSequence) {
                                asClone.add(sa);
                            }
                            asClone.add(a);
                            E.actionSequence = asClone;
                            //Set Cost (Parent Cost + Action Cost)
                            E.setCost(s.cost + p.utility(a));
                            UCSQueue.add(E);
                        }
                    }
                    memUsage = Math.max(memUsage , UCSQueue.size());
                }
            }
        }
        //There is no answer to Problem
        System.err.println("[UCS] No Answer !");
        return null;
    }

    public static void showResult(State finalState){
        System.out.println("");
        //System.out.println("DEPTH: " + depth);
        System.out.println("NODES COUNT: " + (closed.size()+UCSQueue.size()));
        System.out.println("MEMORY USAGE: " + memUsage);
        System.out.println("EXPANDED NODES: "+closed.size());
        System.out.println("VISITED NODES: "+closed.size());
    }

}