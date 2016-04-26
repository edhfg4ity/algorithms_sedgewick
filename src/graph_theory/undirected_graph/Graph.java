package graph_theory.undirected_graph;

import java.util.Scanner;

/**
 * Created by Vincent on 2016/4/16.
 */
public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < adj.length; i++){
            adj[i] = new Bag<Integer>();
        }
    }
    public int V(){
        return this.V;
    }
    public int E(){
        return this.E;
    }
    public void addEdge(int w ,int s) {
        adj[w].add(s);
        adj[s].add(w);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Graph g = new Graph(in.nextInt());
        int E = in.nextInt();
        for(int i = 0; i < E; i++){
            int s = in.nextInt();
            int w = in.nextInt();
            g.addEdge(s, w);
        }
    }

}
