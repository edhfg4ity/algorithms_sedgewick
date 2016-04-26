package graph_theory.directed_graph;


/**
 * Created by Vincent on 2016/4/17.
 * 有向图的强连通分量
 * 按转置图的逆后（拓扑序）序遍历原图，在一个递归里的属于同一个强连通分支
 * 原图s->v,证明转置图中也有s->v,方法是转置图中对v的深度调用在s之后开始，s之前结束，可证；
 */
public class StrongConnect {
    private boolean[] marked;
    private int[] id;
    private int count;
    public StrongConnect(Digraph g){
        marked = new boolean[g.V()];
        id = new int[g.V()];
        DepthFirstOrder dfo = new DepthFirstOrder(g.reverse());
        for(int s : dfo.reverseOrder()){
            if(!marked[s]) {
                dfs(g, s);
                count++;
            }
        }
    }
    private void dfs(Digraph g, int s){
        marked[s] = true;
        id[s] = count;
        for(int v : g.adj(s)){
            if(!marked[v]){
                dfs(g, s);
            }
        }
    }
    public boolean StronglyConnect(int v,int w){
        return id[v] == id[w];
    }
    public int id(int v){
        return id[v];
    }
    public int count(){
        return count;
    }
}
