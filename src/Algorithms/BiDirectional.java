package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import Problems.State;
import Problems.State1;
import Problems.Problem;
import Problems.Action;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;





import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class BiDirectional {
    public static int memUsage=0;
    public static Queue<Evaluate> QueueA = new LinkedList<>();
    public static Queue<Evaluate> QueueB = new LinkedList<>();
    public static ArrayList<Evaluate> closedA = new ArrayList<>();
    public static ArrayList<Evaluate> closedB = new ArrayList<>();

    public static ArrayList<Action> search(Problem p){
        return search(p,true);
    }

    public static ArrayList<Action> search(Problem p,boolean isGraphSearch){



        Evaluate initA = new Evaluate();
        initA.state = p.initialState();
        initA.actionSequence = new ArrayList<>();


        Evaluate initB = new Evaluate();
        initB.state = p.goalState();
        initB.actionSequence = new ArrayList<>();

        System.out.print("init A: ");
        initA.state.print();
        System.out.print("init B: ");
        initB.state.print();

        QueueA.add(initA);
        QueueB.add(initB);
        memUsage++;
        memUsage++;
        boolean d=false;

        while(!QueueA.isEmpty() && !QueueB.isEmpty()){
            System.out.println("new");
            //ArrayList<Action> intersectionResult= intersect(p,closedA,closedB);
            ArrayList<Action> resActions= new ArrayList<>();//= intersect(closedA,closedB);
            for (Evaluate t1: closedA) {
                for (Evaluate t2: closedB){
                    if(p.goalTestBi(t1.state,t2.state)) {
                        System.out.print("A: ");
                        t1.state.print();
                        System.out.print("B: ");
                        t2.state.print();
                        resActions=t1.actionSequence;
                        resActions.addAll(t2.actionSequence);
                        d=true;
                    }
                    }
            }
//            if(intersectionResult != null){
            if(d){
//            Evaluate a = QueueA.remove();
//            Evaluate b = QueueB.remove();
//            //System.out.println(b.state
//            if(a.state.isEquals(b.state)){
                System.out.println("yes");
                //Goal Reached
                showResult();
                System.out.println("[Bidirectional] Goal Reached !");
                return resActions;
            }else{
                System.out.println("else");
            Evaluate a = QueueA.remove();
            Evaluate b = QueueB.remove();
                //Close Current State
                closedA.add(a);
                closedB.add(b);
                //Expand Childs of A
                for(Action act : p.actions(a.state)){
                    for(State targetState : p.result(a.state,act)) {
                        System.out.println("Hi");
                        boolean mustAdd = true;
                        if(isGraphSearch){
                            for (Evaluate closedE : closedA) {
                                if (closedE.state.isEquals(targetState)) {
                                    mustAdd = false;
                                    break;
                                }
                            }
                        }
                        for (Evaluate openState : QueueA) {
                            if (openState.state.isEquals(targetState)) {
                                mustAdd = false;
                                break;
                            }
                        }
                        if (mustAdd) {
                            Evaluate E = new Evaluate();
                            E.state = targetState;
                            //Clone Parent Action Sequence
                            ArrayList<Action> asClone = new ArrayList<>();
                            for (Action sa : a.actionSequence) {
                                asClone.add(sa);
                            }
                            asClone.add(act);
                            E.actionSequence = asClone;
                            QueueA.add(E);
                        }
                    }
                }
                //Expand Childs of B
                for(Action act : p.actionsBd(b.state)){
                    for(State targetState : p.resultBd(b.state,act)) {
                        boolean mustAdd = true;
                        if(isGraphSearch){
                            for (Evaluate closedE : closedB) {
                                if (closedE.state.isEquals(targetState)) {
                                    mustAdd = false;
                                    break;
                                }
                            }
                        }
                        for (Evaluate openState : QueueB) {
                            if (openState.state.isEquals(targetState)) {
                                mustAdd = false;
                                break;
                            }
                        }
                        if (mustAdd) {
                            Evaluate E = new Evaluate();
                            E.state = targetState;
                            //Clone Parent Action Sequence
                            ArrayList<Action> asClone = new ArrayList<>();
                            for (Action sa : b.actionSequence) {
                                asClone.add(sa);
                            }
                            asClone.add(act);
                            E.actionSequence = asClone;
                            QueueB.add(E);
                        }
                    }
                    memUsage = Math.max(memUsage , (QueueB.size()+QueueA.size()));
                }
            }
        }
        //There is no answer to algorithm.Problem
        System.err.println("[Bidirectional] No Answer !");
        return null;
    }

    public static void showResult(){
        System.out.println("");
        //System.out.println("DEPTH: " + depth);
        System.out.println("NODES COUNT: " + (closedB.size()+QueueB.size()+closedA.size()+QueueA.size()));
        System.out.println("MEMORY USAGE: " + memUsage);
        System.out.println("EXPANDED NODES: "+(closedB.size()+closedA.size()));
        System.out.println("VISITED NODES: "+(closedB.size()+closedA.size()));
    }

    private static ArrayList<Action> intersect(Problem p , ArrayList<Evaluate> qOrigin , ArrayList<Evaluate> qGoal){
        for(Evaluate eOrigin : qOrigin){
            for(Evaluate eGoal : qGoal){
                if(eOrigin.state.isEquals(eGoal.state)){
                    ArrayList<Action> finalActions = new ArrayList<>();
                    //Add Actions from Origin Normally
                    for (int i = 0; i < eOrigin.actionSequence.size(); i++) {
                        finalActions.add(eOrigin.actionSequence.get(i));
                    }
                    //Add Actions from Goal Reversed
                    for (int i = eGoal.actionSequence.size() - 1; i >=0 ; i--) {
                        finalActions.add(eGoal.actionSequence.get(i));
                    }

                    return finalActions;
                }
            }
        }
        return null;
    }

}