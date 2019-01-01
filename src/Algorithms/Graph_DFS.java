package Algorithms;

import java.util.ArrayList;
import java.util.Stack;

import Problems.State;
import Problems.State1;
import Problems.Problem;
import Problems.Action;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



        import java.util.ArrayList;
        import java.util.Stack;

public class Graph_DFS {
    public static int memUsage=0;
    public static Stack<Evaluate> DFSStack = new Stack<>();
    public static ArrayList<State> closed = new ArrayList<>();
    //Search without Depth Limit
    public static ArrayList<Action> search(Problem p){
        return search(p,-1);

    }

    public static ArrayList<Action> search(Problem p,int depthLimit){
        return search(p,depthLimit,true);
    }

    //Search with Depth Limit (DLS)
    public static ArrayList<Action> search(Problem p,int depthLimit,boolean isGraphSearch){



        Evaluate initE = new Evaluate();
        initE.state = p.initialState();
        initE.actionSequence = new ArrayList<>();

        DFSStack.add(initE);
        memUsage++;

        while(!DFSStack.empty()){
            Evaluate s = DFSStack.pop();
            if(p.goalTest(s.state)){
                //Goal Reached
                showResult(s.state);
                System.out.println("[DFS] Goal Reached !");
                return s.actionSequence;
            }else{
                //Close Current State
                closed.add(s.state);
                //Dont Expand if Depth Limit Reached
                if(depthLimit != -1 && s.actionSequence.size() >= depthLimit) continue;
                //Expand Childs
                for(Action a : p.actions(s.state)){
                    for(State targetState : p.result(s.state,a)) {
                        boolean mustAdd = true;
                        if(isGraphSearch) {
                            for (State closedState : closed) {
                                if (closedState.isEquals(targetState)) {
                                    mustAdd = false;
                                    break;
                                }
                            }
                        }
                        for (Evaluate openState : DFSStack) {
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
                            DFSStack.push(SAS);
                        }
                        memUsage = Math.max(memUsage , DFSStack.size());
                    }
                }
            }
        }
        //There is no answer to Problem
        System.err.println("[DFS] No Answer !");
        return null;
    }
    public static void showResult(State finalState){
        System.out.println("");
        //System.out.println("DEPTH: " + depth);
        System.out.println("NODES COUNT: " + (closed.size()+DFSStack.size()));
        System.out.println("MEMORY USAGE: " + memUsage);
        System.out.println("EXPANDED NODES: "+closed.size());
        System.out.println("VISITED NODES: "+closed.size());
    }

}
