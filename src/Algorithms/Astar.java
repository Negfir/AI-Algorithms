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
import java.util.PriorityQueue;

public class Astar {
    public static int memUsage=0;
    public static PriorityQueue<Evaluate> ASQueue = new PriorityQueue<>(Evaluate.costComparator);
    public static ArrayList<State> closed = new ArrayList<>();

    public static ArrayList<Action> search(Problem p){



        Evaluate initE = new Evaluate();
        initE.state = p.initialState();
        initE.actionSequence = new ArrayList<>();

        ASQueue.add(initE);
        memUsage++;
        while(!ASQueue.isEmpty()){
            Evaluate s = ASQueue.remove();
            if(p.goalTest(s.state)){
                //Goal Reached
                showResult(s.state);
                System.out.println("[AStar] Goal Reached !");
                return s.actionSequence;
            }else{
                //Close Current State
                closed.add(s.state);
                //Expand Childs
                for(Action a : p.actions(s.state)){
                    for(State targetState : p.result(s.state,a)) {
                        boolean mustAdd = true;
                        for (State closedState : closed) {
                            if (closedState.isEquals(targetState)) {
                                mustAdd = false;
                                break;
                            }
                        }
                        for (Evaluate openState : ASQueue) {
                            if (openState.state.isEquals(targetState)) {
                                //must update is less cost reached
                                if (s.cost + (p.utility(a) + p.heuristic(targetState)) < openState.getCost()) {
                                    openState.setCost(s.cost + (p.utility(a) + p.heuristic(targetState)));
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
                            //Set Cost (Parent Cost + Action Cost + Target Heuristic)
                            E.setCost(s.cost + (p.utility(a) + p.heuristic(targetState)));
                            ASQueue.add(E);
                        }
                    }
                    memUsage = Math.max(memUsage , ASQueue.size());
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
        System.out.println("NODES COUNT: " + (closed.size()+ASQueue.size()));
        System.out.println("MEMORY USAGE: " + memUsage);
        System.out.println("EXPANDED NODES: "+closed.size());
        System.out.println("VISITED NODES: "+closed.size());
    }
}