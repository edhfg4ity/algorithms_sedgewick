package graph_theory.undirected_graph;

/**
 * Created by Administrator on 2016/4/16.
 */
//无向图联通分量(利用DFS)
public class Unicom_component {
    private boolean[] marked;
    private int[] id;
    private int count;
    public Unicom_component(Graph g){
        marked = new boolean[g.V()];
        id = new int[g.V()];
        this.count = 0;
        for(int s = 0; s < g.V(); s++){
            if(!marked[s]){
                dfs(g, s);
                count++;
            }
        }
    }
    private void dfs(Graph g, int s){
        marked[s] = true;
        id[s] = count;
        for(int w : g.adj(s)){
            if(!marked[w]){
                dfs(g, w);
            }
        }
    }
    public boolean isConnected(int s ,int v){
        return id[s]==id[v];
    }
    public int count(){
        return count;
    }
    public int id(int v){
        return id[v];
    }
}