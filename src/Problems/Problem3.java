package Problems;


import Problems.Action;
import Problems.Problem;
import Problems.State;
import Problems.State2;

import java.util.ArrayList;

public class Problem3 implements Problem {
    public static int node;

    private int[][] init;
    private int[][] initCopy;
    private int[][] chessGreen;
    public static int x,y;

    public Problem3(int[][] init){
        node=0;
        this.init = init;
        this.initCopy=init;
        int iH = -1 ,jH = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(init[i][j] == 1){
                    x=i;
                    y=j;
                    iH = i;
                    jH = j;
                    System.out.println(init[i][j]+"-"+j+"-"+i);
                }
            }
        }
        if(!(iH == -1 || jH == -1)) {
        //initCopy[iH][jH]=0;
        System.out.println(x+","+y);
        }
    }

    @Override
    public State initialState() {
        return new State3(x,y);
    }

    @Override
    public ArrayList<Action> actions(State s) {
        State3 chess = (State3)s;
        ArrayList<Action> acts = new ArrayList<>();



        //0 : Move Left
        //1 : Move Up
        //2 : Move Right
        //3 : Move Down

        //Move Left


        if(((State3) s).y > 0 && init[((State3) s).x][((State3) s).y-1]!=-1) acts.add(new Action(0,"left"));

        //Move Up
        if(((State3) s).x > 0 && init[((State3) s).x-1][((State3) s).y]!=-1) acts.add(new Action(1,"up"));

        //Move Right
        if(((State3) s).y < 7 && init[((State3) s).x][((State3) s).y+1]!=-1) acts.add(new Action(2,"right"));

        //Move Down
        if(((State3) s).x < 7 && init[((State3) s).x+1][((State3) s).y]!=-1) acts.add(new Action(3,"down"));

        return acts;
    }

    @Override
    public ArrayList<State> result(State s, Action a) {
        State3 cs = (State3)s;





        ArrayList<State> nextState = new ArrayList<>();
        switch(a.actionType){
            case 0:
                nextState.add(new State3(cs.x,cs.y-1));
                //nextState.P[iH][jH] = cs.P[iH][jH];
                //nextState.P[iH][jH-1] = 1;

                break;

            case 1:
                nextState.add(new State3(cs.x-1,cs.y));
                //nextState.P[iH][jH] = init[iH][jH];
                //nextState.P[iH-1][jH] = 1;
                break;

            case 2:
                nextState.add(new State3(cs.x,cs.y+1));
                //nextState.P[iH][jH] =init[iH][jH];
                //nextState.P[iH][jH+1] = 1;
                break;

            case 3:
                nextState.add(new State3(cs.x+1,cs.y));
                //nextState.P[iH][jH] = init[iH][jH];
                //nextState.P[iH+1][jH] = 1;
                break;
        }
        node++;

        return nextState;
    }
    @Override
    public int getNode(){
        return node;
    }

    @Override
    public boolean goalTest(State s) {
        State3 testC = (State3)s;
        //int n = 0;

                System.out.println(testC.x+","+testC.y+" and "+init[testC.x][testC.y]);
                if (!(init[testC.x][testC.y]==2)) return false;

        return true;
    }

    @Override
    public int utility(Action a) {
        return 1;
    }

    @Override
    public int heuristic(State s) {
        State3 chessH = (State3)s;
        int h = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int val = chessH.P[i][j];
                int ti = val / 8;
                int tj = val % 8;
                h += Math.abs(i - ti) + Math.abs(j - tj);
            }
        }
        return h;
    }
    @Override
    public boolean goalTestBi(State s1,State s2) {

        return true;}

    @Override
    public ArrayList<Action> actionsBd(State s) {


        ArrayList<Action> nextState = new ArrayList<>();

        return nextState;
    }
    @Override
    public ArrayList<State> resultBd(State s, Action a) {


        ArrayList<State> nextState = new ArrayList<>();

        return nextState;
    }

    @Override
    public State goalState() {
        return new State3(x,y);
    }

}

