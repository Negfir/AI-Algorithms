package Problems;

import java.util.ArrayList;

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
        return (ps.isPassed == isPassed && ps.notPassed == notPassed);
    }


@Override
    public void update(State s){

        isPassed=(ArrayList) ((State1) s).isPassed.clone();
        notPassed=(ArrayList)((State1) s).notPassed.clone();
    }
}