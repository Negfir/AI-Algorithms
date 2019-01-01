package Problems;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem1 implements Problem {

    public ArrayList<String> isPassed=new ArrayList<String>();
    public ArrayList<String> notPassed=new ArrayList<String>();

public  int node;

    public Problem1(){
        node=0;
        notPassed.add("A1");
        notPassed.add("A2");
        notPassed.add("B1");

        notPassed.add("C2");
        notPassed.add("D1");
        notPassed.add("D2");
        notPassed.add("B2");
        notPassed.add("C1");


    }



    @Override
    public State initialState() {
        return new State1(isPassed,notPassed);
    }

    @Override
    public ArrayList<Action> actions(State s) {
        // 1 : A1,A2
        // 2 : A1,B1
        // 3 : A1,C1
        // 4 : A1,D1
        // 5 : A1
        // 6 : A2,B2
        // 7 : A2,C2
        // 8 : A2,D2
        // 9 : A2
        // 10 : B1,B2
        // 11 : B1,C1
        // 12 : B1,D1
        // 13 : B1
        // 14 : B2,C2
        // 15 : B2,D2
        // 16 : B2
        // 17 : C1,C2
        // 18 : C1,D1
        // 19 : C1
        // 20 : C2,D2
        // 21 : C2
        // 22 : D1,D2
        // 23 : D1
        // 24 : D2

        State1 s1 = (State1)s;
        ArrayList<Action> acts = new ArrayList<>();

        if(s1.notPassed.contains("A1")) {
            if(s1.notPassed.contains("A2")) acts.add(new Action(1,"A1,A2"));
            if(s1.notPassed.contains("B1")) acts.add(new Action(2,"A1,B1"));
            if(s1.notPassed.contains("C1")) acts.add(new Action(3,"A1,C1"));
            if(s1.notPassed.contains("D1")) acts.add(new Action(4,"A1,D1"));
            acts.add(new Action(5,"A1"));}
        if(s1.notPassed.contains("A2")) {
            if(s1.notPassed.contains("B2")) acts.add(new Action(6,"A2,B2"));
            if(s1.notPassed.contains("C2")) acts.add(new Action(7,"A2,C2"));
            if(s1.notPassed.contains("D2")) acts.add(new Action(8,"A2,D2"));
            acts.add(new Action(9,"A2"));}

        if(s1.notPassed.contains("B1")) {
            if(s1.notPassed.contains("B2")) acts.add(new Action(10,"B1,B2"));
            if(s1.notPassed.contains("C1")) acts.add(new Action(11,"B1,C1"));
            if(s1.notPassed.contains("D1")) acts.add(new Action(12,"B1,D1"));
            acts.add(new Action(13,"B1"));}
        if(s1.notPassed.contains("B2")) {
            if(s1.notPassed.contains("C2")) acts.add(new Action(14,"B2,C2"));
            if(s1.notPassed.contains("D2")) acts.add(new Action(15,"B2,D2"));
            acts.add(new Action(16,"B2"));}
        if(s1.notPassed.contains("C1")) {
            if(s1.notPassed.contains("C2")) acts.add(new Action(17,"C1,C2"));
            if(s1.notPassed.contains("D1")) acts.add(new Action(18,"C1,D1"));
            acts.add(new Action(1,"C1"));}
        if(s1.notPassed.contains("C2")) {
            if(s1.notPassed.contains("D2")) acts.add(new Action(20,"C2,D2"));
            acts.add(new Action(21,"C2"));}
        if(s1.notPassed.contains("D1")) {
            if(s1.notPassed.contains("D2")) acts.add(new Action(22,"D1,D2"));
            acts.add(new Action(23,"D1"));}
        //jj
        if(s1.notPassed.contains("D2")) {
            acts.add(new Action(24,"D2"));}
        return acts;
    }

    @Override
    public ArrayList<State> result(State s, Action a) {
        State1 current = (State1)s;
        ArrayList<String> notP=(ArrayList) current.notPassed.clone();
        ArrayList<String> isP=(ArrayList) current.isPassed.clone();

        switch(a.actionType){
            case 1:
                notP.remove("A1");
                notP.remove("A2");
                isP.add("A1");
                isP.add("A2");
                break;
            case 2:
                notP.remove("A1");
                notP.remove("B1");
                isP.add("A1");
                isP.add("B1");
                break;
            case 3:
                notP.remove("A1");
                notP.remove("C1");
                isP.add("A1");
                isP.add("C1");
                break;
            case 4:
                notP.remove("A1");
                notP.remove("D1");
                isP.add("A1");
                isP.add("D1");
                break;
            case 5:
                notP.remove("A1");

                isP.add("A1");

                break;
            case 6:
                notP.remove("A2");
                notP.remove("B2");
                isP.add("A2");
                isP.add("B2");
                break;
            case 7:
                notP.remove("A2");
                notP.remove("C2");
                isP.add("A2");
                isP.add("C2");
                break;
            case 8:
                notP.remove("A1");
                notP.remove("D2");
                isP.add("A1");
                isP.add("D2");
                break;
            case 9:
                notP.remove("A2");

                isP.add("A2");

                break;
            case 10:
                notP.remove("B1");
                notP.remove("B2");
                isP.add("B1");
                isP.add("B2");
                break;
            case 11:
                notP.remove("B1");
                notP.remove("C1");
                isP.add("B1");
                isP.add("C1");
                break;
            case 12:
                notP.remove("B1");
                notP.remove("D1");
                isP.add("B1");
                isP.add("D1");
                break;
            case 13:
                notP.remove("B1");

                isP.add("B1");

                break;
            case 14:
                notP.remove("B2");
                notP.remove("C2");
                isP.add("B2");
                isP.add("C2");
                break;
            case 15:
                notP.remove("B2");
                notP.remove("D2");
                isP.add("B2");
                isP.add("D2");
                break;
            case 16:
                notP.remove("B2");

                isP.add("B2");

                break;
            case 17:
                notP.remove("C1");
                notP.remove("C2");
                isP.add("C1");
                isP.add("C2");
                break;
            case 18:
                notP.remove("C1");
                notP.remove("D1");
                isP.add("C1");
                isP.add("D1");
                break;
            case 19:
                notP.remove("C1");

                isP.add("C1");

                break;
            case 20:
                notP.remove("C2");
                notP.remove("D2");
                isP.add("C2");
                isP.add("D2");
                break;
            case 21:
                notP.remove("C2");

                isP.add("C2");

                break;
            case 22:
                notP.remove("D1");
                notP.remove("D2");
                isP.add("D1");
                isP.add("D2");
                break;
            case 23:
                notP.remove("D1");

                isP.add("D1");

                break;
            case 24:
                notP.remove("D2");

                isP.add("D2");

                break;

        }

        ArrayList<State> nextState = new ArrayList<>();
        nextState.add(new State1(isP,notP));
        node++;

        for (String i: isP){
            System.out.print(i+"-");
        }


        return nextState;
    }
@Override
    public int getNode(){
        return node;
    }
    @Override
    public boolean goalTestBi(State s1,State s2) {
        State s11 = (State1) s1;
        State s21 = (State1) s2;
        return (new HashSet<>(((State1) s11).isPassed).equals(new HashSet<>(((State1) s21).isPassed))) && (new HashSet<>(((State1) s11).notPassed).equals(new HashSet<>(((State1) s21).notPassed)));
    }
    @Override
    public boolean goalTest(State s) {
        State s1 = (State1)s;

        if(((State1) s1).notPassed.isEmpty()) System.out.print("final"+((State1) s1).isPassed+"-");
        return (((State1) s1).notPassed.isEmpty());
    }

    @Override
    public int utility(Action a) {
        return 1;
    }

    @Override
    public int heuristic(State s) {
        System.err.println("Heuristic is Not Supported in this Problem !");
        throw new NotImplementedException();
    }


    @Override
    public State goalState() {
        return new State1(notPassed,isPassed);
    }



//    @Override
//    public float[] bestPath(State finalState) {
//        ArrayList<State> path = new ArrayList<>();
//        State nextState = (State1) finalState;
//        path.add(nextState);
//        while(((State1) nextState).notPassed != null){
//            nextState = nextState.previousState;
//            path.add(nextState);
//        }
//
//        for (int i = path.size()-12 ; i >=0; i--){
//            State state = (State) path.get(i);
//            System.out.println("("+state.firstPitcherFilled + "," + state.secondPicherFilled + ")");
//        }
//
//        float[] out = new float[2];
//        out[0] = path.size();
//        out[1]= pathCost(path);
//
//        return out;
//    }

    @Override
    public ArrayList<Action> actionsBd(State s) {
        State1 s1 = (State1)s;
        ArrayList<Action> acts = new ArrayList<>();
        if(s1.isPassed.contains("A1")) {
            if(s1.isPassed.contains("A2")) acts.add(new Action(1,"A1,A2"));
            if(s1.isPassed.contains("B1")) acts.add(new Action(2,"A1,B1"));
            if(s1.isPassed.contains("C1")) acts.add(new Action(3,"A1,C1"));
            if(s1.isPassed.contains("D1")) acts.add(new Action(4,"A1,D1"));
            acts.add(new Action(5,"A1"));}
        if(s1.isPassed.contains("A2")) {
            if(s1.isPassed.contains("B2")) acts.add(new Action(6,"A2,B2"));
            if(s1.isPassed.contains("C2")) acts.add(new Action(7,"A2,C2"));
            if(s1.isPassed.contains("D2")) acts.add(new Action(8,"A2,D2"));
            acts.add(new Action(9,"A2"));}

        if(s1.isPassed.contains("B1")) {
            if(s1.isPassed.contains("B2")) acts.add(new Action(10,"B1,B2"));
            if(s1.isPassed.contains("C1")) acts.add(new Action(11,"B1,C1"));
            if(s1.isPassed.contains("D1")) acts.add(new Action(12,"B1,D1"));
            acts.add(new Action(13,"B1"));}
        if(s1.isPassed.contains("B2")) {
            if(s1.isPassed.contains("C2")) acts.add(new Action(14,"B2,C2"));
            if(s1.isPassed.contains("D2")) acts.add(new Action(15,"B2,D2"));
            acts.add(new Action(16,"B2"));}
        if(s1.isPassed.contains("C1")) {
            if(s1.isPassed.contains("C2")) acts.add(new Action(17,"C1,C2"));
            if(s1.isPassed.contains("D1")) acts.add(new Action(18,"C1,D1"));
            acts.add(new Action(1,"C1"));}
        if(s1.isPassed.contains("C2")) {
            if(s1.isPassed.contains("D2")) acts.add(new Action(20,"C2,D2"));
            acts.add(new Action(21,"C2"));}
        if(s1.isPassed.contains("D1")) {
            if(s1.isPassed.contains("D2")) acts.add(new Action(22,"D1,D2"));
            acts.add(new Action(23,"D1"));}
        //jj
        if(s1.isPassed.contains("D2")) {
            acts.add(new Action(24,"D2"));}
        return acts;
        //jj
    }

    @Override
    public ArrayList<State> resultBd(State s, Action a) {
        State1 current = (State1)s;
        ArrayList<String> isP=(ArrayList) current.notPassed.clone();
        ArrayList<String> notP=(ArrayList) current.isPassed.clone();

        switch(a.actionType){
            case 1:
                notP.remove("A1");
                notP.remove("A2");
                isP.add("A1");
                isP.add("A2");

                break;
            case 2:
                notP.remove("A1");
                notP.remove("B1");
                isP.add("A1");
                isP.add("B1");
                break;
            case 3:
                notP.remove("A1");
                notP.remove("C1");
                isP.add("A1");
                isP.add("C1");
                break;
            case 4:
                notP.remove("A1");
                notP.remove("D1");
                isP.add("A1");
                isP.add("D1");
                break;
            case 5:
                notP.remove("A1");

                isP.add("A1");

                break;
            case 6:
                notP.remove("A2");
                notP.remove("B2");
                isP.add("A2");
                isP.add("B2");
                break;
            case 7:
                notP.remove("A2");
                notP.remove("C2");
                isP.add("A2");
                isP.add("C2");
                break;
            case 8:
                notP.remove("A1");
                notP.remove("D2");
                isP.add("A1");
                isP.add("D2");
                break;
            case 9:
                notP.remove("A2");

                isP.add("A2");

                break;
            case 10:
                notP.remove("B1");
                notP.remove("B2");
                isP.add("B1");
                isP.add("B2");
                break;
            case 11:
                notP.remove("B1");
                notP.remove("C1");
                isP.add("B1");
                isP.add("C1");
                break;
            case 12:
                notP.remove("B1");
                notP.remove("D1");
                isP.add("B1");
                isP.add("D1");
                break;
            case 13:
                notP.remove("B1");

                isP.add("B1");

                break;
            case 14:
                notP.remove("B2");
                notP.remove("C2");
                isP.add("B2");
                isP.add("C2");
                break;
            case 15:
                notP.remove("B2");
                notP.remove("D2");
                isP.add("B2");
                isP.add("D2");
                break;
            case 16:
                notP.remove("B2");

                isP.add("B2");

                break;
            case 17:
                notP.remove("C1");
                notP.remove("C2");
                isP.add("C1");
                isP.add("C2");
                break;
            case 18:
                notP.remove("C1");
                notP.remove("D1");
                isP.add("C1");
                isP.add("D1");
                break;
            case 19:
                notP.remove("C1");

                isP.add("C1");

                break;
            case 20:
                notP.remove("C2");
                notP.remove("D2");
                isP.add("C2");
                isP.add("D2");
                break;
            case 21:
                notP.remove("C2");

                isP.add("C2");

                break;
            case 22:
                notP.remove("D1");
                notP.remove("D2");
                isP.add("D1");
                isP.add("D2");
                break;
            case 23:
                notP.remove("D1");

                isP.add("D1");

                break;
            case 24:
                notP.remove("D2");

                isP.add("D2");

                break;

        }

        ArrayList<State> nextState = new ArrayList<>();
        nextState.add(new State1(notP,isP));
        System.out.print("action1: ");
        nextState.get(0).print();

        for (String i: isP){
            System.out.print(i+"-");
        }


        return nextState;
    }


}


