package Problems;

class State2 implements State {

    public int[][] P;

    public State2(int[][] in){
        P = in;
    }

    public State2 clone(){
        int[][] NP = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                NP[i][j] = P[i][j];
            }
        }
        return new State2(NP);
    }

    @Override
    public void print(){

    }

    public boolean isEquals(State s){
        if(s instanceof State2) {
            State2 eps = (State2) s;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (P[i][j] != eps.P[i][j]) return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    public void update(State s){

    }
}