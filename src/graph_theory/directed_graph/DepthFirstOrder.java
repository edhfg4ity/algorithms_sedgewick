package graph_theory.directed_graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2016/4/17.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reverseOrder;
    public DepthFirstOrder(Digraph g){
        pre = new PriorityQueue<Integer>();
        post = new PriorityQueue<Integer>();
        reverseOrder = new Stack<Integer>();
        marked = new boolean[g.V()];
        for(int v =0; v < g.V(); v++)
            dfs(g, v);
    }
    private void dfs(Digraph g, int s){
        pre.add(s);
        marked[s] = true;
        for(int w : g.adj(s)){
            if(!marked[w])
                dfs(g, s);
        }
        post.add(s);
        reverseOrder.push(s);
    }
    public boolean marked(int v){
        return marked[v];
    }
    public Iterable<Integer> pre(){return pre;}
    public Iterable<Integer> post(){return post;}
    public Iterable<Integer> reverseOrder(){return reverseOrder;}
}
