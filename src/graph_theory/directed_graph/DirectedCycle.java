package graph_theory.directed_graph;

import graph_theory.undirected_graph.Graph;
import java.util.Stack;

/**
 * Created by Administrator on 2016/4/16.
 */
public class DirectedCycle {
    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    public DirectedCycle(Graph g){
        marked = new boolean[g.V()];
        onStack = new boolean[g.V()];
        edgeTo = new int[g.V()];
        for(int v = 0; v < g.V(); v++)
            if(!marked[v]) dfs(g, v);
    }
    private void dfs(Graph g, int v){
        marked[v] = true;
        onStack[v] = true;
        for(int w : g.adj(v)){
            if(this.isCycle()) return;
            else if(!marked[w]){
                edgeTo[w] = v ;
                dfs(g, v);
            }else if(onStack[w]){
                cycle = new Stack<Integer>();
                while(w != v){
                    cycle.push(edgeTo[w]);
                    w = edgeTo[w];
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    public boolean isCycle(){
        return cycle != null;
    }
    public Iterable<Integer> cycle(){
        return cycle;
    }
}
