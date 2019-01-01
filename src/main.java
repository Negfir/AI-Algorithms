//import Algorithms.Astar.As_Graph;
//import Algorithms.Astar.As_Tree;
import Algorithms.*;
//import Algorithms.Bidirectional.Bidirectional_Graph;
//import Algorithms.Bidirectional.Bidirectional_Tree;
//import Algorithms.DFS.dfs.DFS_Graph;
//import Algorithms.DFS.dfs.DFS_Tree;
//import Algorithms.DFS.iterativeDeepening.DFS_iterativeDeepening_Graph;
//import Algorithms.DFS.limitDepth.DFS_limitDepth_Grapth;
//import Algorithms.DFS.limitDepth.DFS_limitDepth_Tree;
//import Algorithms.UniformCostSearch.UCS_Graph;
//import Algorithms.UniformCostSearch.UCS_Tree;
//
import Algorithms.Graph_DFS;
import Problems.Problem1;
import Problems.Problem2;
import Problems.Action;
import Problems.Problem3;

import Algorithms.Graph_BFS;

import java.util.ArrayList;

public class main {
    public static void main(String[] args){

        int [][] init2 = {
                {0, 1, 4},
                {3, 5, 2},
                {6, 7, 8}
        };

        int [][] init3 = {
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, -1, 0, 0},
                {0, 0, 0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, -1, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 0}
        };
//        int [][] start3 = {
//                {0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {-1, -1, 0, 0, 0, 0, 0, 0},
//                {0, 0, -1, 0, 0, -1, -1, 0},
//                {0, 0, 0, -1, 0, -1, 0, 0},
//                {0, 0, 0, 0, -1, 0, 0, 0},
//                {2, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 2, 0, 0, 0}
//        };
        Problem1 p1b = new Problem1();
        //Graph BST
//        ArrayList<Action> actions1 = Graph_BFS.search(p1b,true);
//        if(actions1 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions1) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");

        //Tree BST
//        ArrayList<Action> actions2 = Graph_BFS.search(p1b,false);
//        if(actions2 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions2) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");
//
//        //Bi directional
//        ArrayList<Action> actions3 = BiDirectional.search(p1b,true);
//        if(actions3 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions3) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");
//
//        //Graph DFS
//        ArrayList<Action> actions4 = Graph_DFS.search(p1b,-1);
//        if(actions4 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions4) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");

        Problem2 p2b = new Problem2(init2);

        //Graph BFS
//        ArrayList<Action> actions5 = Graph_BFS.search(p2b,true);
//        if(actions5 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions5) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");

        //Tree DFS
//        ArrayList<Action> actions6 = Graph_DFS.search(p2b,8,false);
//        if(actions6 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions6) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");

        //ID
//        ArrayList<Action> actions7 = IterativeDeepening.search(p2b,false);
//        if(actions7 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions7) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");


        //A*
//        ArrayList<Action> actions8 = Astar.search(p2b);
//        if(actions8 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions8) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");

        Problem3 p3b = new Problem3(init3);

        //UCS
//        ArrayList<Action> actions9 = UniformCost.search(p3b);
//        if(actions9 != null){
//            //System.out.print(actions3.size()+"-------");
//            for(Action a : actions9) {System.out.print(a.s + " -> ");}
//        }
//        System.out.println(" ");

        //ID
        ArrayList<Action> actions10 = IterativeDeepening.search(p3b,false);
        if(actions10 != null){
            //System.out.print(actions3.size()+"-------");
            for(Action a : actions10) {System.out.print(a.s + " -> ");}
        }
        System.out.println(" ");



    }
}
