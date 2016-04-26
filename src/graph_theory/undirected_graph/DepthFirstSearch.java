package graph_theory.undirected_graph;

import java.util.Stack;

/**
 * Created by Vincent on 2016/4/16.
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;
    private int[] edgeTo;
    private int s;
    public DepthFirstSearch(Graph g,int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g,s);
    }
    private void dfs(Graph g, int v){
        marked[v] = true;
        count++;
        for(int w : g.adj(v)){
            if(marked[w] != true) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }
    public Iterable<Integer> pathTo(int v){
        if(!marked(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        while(v != s){
            path.push(v);
            v = edgeTo[v];
        }
        path.push(s);
        return path;
    }
    public void printPath(Graph g, int s){
        DepthFirstSearch search = new DepthFirstSearch(g,s);
        for(int v = 0; v < g.V(); v++){
            if(marked(v)){
                for(int x : search.pathTo(v)){
                    System.out.println(v + "");
                }
            }
        }
    }
}
