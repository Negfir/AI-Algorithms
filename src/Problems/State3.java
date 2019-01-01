package Problems;

class State3 implements State {

    public int[][] P;
    public int x;
    public int y;

    public State3(int x,int y){
        this.x = x;
        this.y = y;
    }




    public boolean isEquals(State s){
        State3 s3 = (State3) s;
        return (s3.x == x && s3.y == y);
    }


@Override
public void print(){

}
    public void update(State s){

    }
}