package Problems;

import java.util.ArrayList;

public interface State {

    public boolean isEquals(State s);

    public void update(State s);
    public void print();
}
