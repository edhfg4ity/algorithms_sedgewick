package graph_theory.directed_graph;
import graph_theory.undirected_graph.Bag;

/**
 * Created by Vincent on 2016/4/16.
 */
public class Digraph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;
    public Digraph(int v){
        this.V = v;
        for(int i = 0; i < v; i++){
            adj[i] = new Bag<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void add(int w, int v){
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){return adj[v];}
    public Iterable<Integer> ListIterator(int v){
        return adj[v];
    }
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int i = 0; i < V; i++){
            for(int w : adj[i])
                R.add(w, i);
        }
        return R;
    }
}
