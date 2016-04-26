package graph_theory.min_spanning_tree;

import graph_theory.undirected_graph.Bag;

/**
 * Created by Vincent on 2016/4/17.
 */
public class EdgeWeightedGraph {
    private int V;
    private int E;
    private Bag<Edge>[] adj;
    public EdgeWeightedGraph(int v, int e){
        this.V = v;
        this.E = e;
        adj = (Bag<Edge>[]) new Bag[v];
        for(int i = 0; i < v; i++)
            adj[i] = new Bag<Edge>();
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(Edge e){
        adj[e.either()].add(e);
        adj[e.other(e.either())].add(e);
        E++;
    }
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
    public Iterable<Edge> edges(){
        Bag<Edge> res = new Bag<Edge>();
        for(int v = 0; v < V; v++){
            for(Edge e : adj[v])
                if(e.other(v) > v)res.add(e);
        }
        return res;
    }
}
