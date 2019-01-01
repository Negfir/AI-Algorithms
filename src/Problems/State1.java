package Problems;

import java.util.ArrayList;
import java.util.HashSet;


public class State1 implements State{

    public ArrayList<String> isPassed=new ArrayList<String>();;
    public ArrayList<String> notPassed=new ArrayList<String>();;


    public State1(ArrayList<String> x,ArrayList<String> y){
        isPassed=(ArrayList) x.clone();
        notPassed=(ArrayList) y.clone();
    }
    @Override
    public boolean isEquals(State s){
        State1 ps = (State1)s;
        return (new HashSet<>(isPassed).equals(new HashSet<>(ps.isPassed))) && (new HashSet<>(notPassed).equals(new HashSet<>(ps.notPassed)));
    }

    @Override
    public void print(){
        System.out.println("is Passed:"+isPassed+"-"+"not Passed"+notPassed);
    }


@Override
    public void update(State s){

        isPassed=(ArrayList) ((State1) s).isPassed.clone();
        notPassed=(ArrayList)((State1) s).notPassed.clone();
    }
}