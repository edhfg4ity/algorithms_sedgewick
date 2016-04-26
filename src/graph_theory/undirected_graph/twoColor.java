package graph_theory.undirected_graph;

/**
 * Created by Administrator on 2016/4/16.
 */
//是否是二分图（双色问题）
public class twoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isColor = true;
    public twoColor(Graph g){
        marked = new boolean[g.V()];
        color = new boolean[g.V()];
        for(int s = 0; s < g.V(); s++){
            if(!marked[s])
                dfs(g,s);
        }
    }
    private void dfs(Graph g, int v){
        marked[v] = true;
        for(int w : g.adj(v)){
            if(!marked[w]){
                color[w] = !color[v];
                dfs(g, w);
            }else if(color[w] == color[v])
                isColor = false;
        }
    }
    public boolean isColor(){
        return isColor;
    }
}

