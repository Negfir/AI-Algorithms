package Algorithms;

import java.util.ArrayList;
import Problems.Problem;
import Problems.Action;

public class IterativeDeepening {


    public static ArrayList<Action> search(Problem p){
        return search(p,true);
    }

    public static ArrayList<Action> search(Problem p,boolean isGraphSearch){
        int l = 1;
        while(true) {
            ArrayList<Action> result = Graph_DFS.search(p, l,isGraphSearch);

            if (result != null) return result;
            else l++;
        }
    }
}

