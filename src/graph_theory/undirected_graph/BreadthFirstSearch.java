package graph_theory.undirected_graph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Vincent on 2016/4/16.
 */
public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int count;
    private int s;
    public BreadthFirstSearch(Graph g, int s){
        marked = new boolean[g.V()];
        this.s = s;
        this.count = 0;
        edgeTo = new int[g.V()];
        bfs(g, s);
    }
    private void bfs(Graph g, int s){
        Queue<Integer> q = new PriorityQueue<Integer>();
        marked[s] = true;
        q.add(s);
        while(!q.isEmpty()){
            int v = q.poll();
            count++;
            for(int w : g.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    q.add(w);
                }
            }
        }
    }
    public boolean marked(int v){
        return marked[v];
    }
    public int count(){
        return count;
    }
}
