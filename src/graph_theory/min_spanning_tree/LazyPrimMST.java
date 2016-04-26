package graph_theory.min_spanning_tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Vincent on 2016/4/18.
 */
public class LazyPrimMST {
    private  MinPQ<Edge> pq;
    private boolean[] marked;
    private Queue<Edge> mst;
    public LazyPrimMST(EdgeWeightedGraph g){
        pq = new MinPQ<Edge>(g.E());
        marked = new boolean[g.V()];
        mst = new PriorityQueue<Edge>();
        visit(g, 0);
        while(!pq.isEmpty()){
            Edge e = pq.deleteMin();
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.add(e);
            if(!marked[v]) visit(g, v);
            if(!marked[w]) visit(g, w);
        }
    }
    private void visit(EdgeWeightedGraph g, int v){
        marked[v] = true;
        for(Edge w : g.adj(v))
            if(!marked[w.other(v)]) pq.insert(w);
    }

}
