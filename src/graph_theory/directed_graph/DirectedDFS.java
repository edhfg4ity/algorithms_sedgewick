package graph_theory.directed_graph;


/**
 * Created by Administrator on 2016/4/16.
 */
//有向图的可达性(DFS)
public class DirectedDFS {
    private boolean[] marked;
    public DirectedDFS(Digraph g, int s){
        marked = new boolean[g.V()];
        dfs(g, s);
    }
    public DirectedDFS(Digraph g, Iterable<Integer> sources){
        marked = new boolean[g.V()];
        for(int v: sources){
            if(!marked[v])
                dfs(g, v);
        }
    }
    private void dfs(Digraph g, int s){
        marked[s] = true;
        for(int w : g.adj(s)){
            if(!marked[w])
                dfs(g, s);
        }
    }
    public boolean marked(int v){
        return marked[v];
    }
}
