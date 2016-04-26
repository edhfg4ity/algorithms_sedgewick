package graph_theory.min_spanning_tree;

import graph_theory.union_find.WeightedUF;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Vincent on 2016/4/18.
 * 利用了UF和最小堆优先队列等数据结构的支持，所以说算法是基于数据结构的
 * 设计合适的数据结构很重要
 */
public class KruskalMST {
    private Queue<Edge> mst;
    public KruskalMST(EdgeWeightedGraph g){
        MinPQ<Edge> pq = new MinPQ<Edge>(g.edges());
        mst = new PriorityQueue<>();
        WeightedUF uf = new WeightedUF(g.V());
        while(!pq.isEmpty() && mst.size() < g.V() -1){
            Edge min = pq.deleteMin();
            int i = min.either();
            int j = min.other(i);
            if(uf.isConnect(i, j)) continue;
            uf.union(i, j);
            mst.add(min);
        }
    }
    public Iterable<Edge> edges(){
        return mst;
    }
}
