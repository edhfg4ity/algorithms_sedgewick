package graph_theory.union_find;

/**
 * Created by Vincent on 2016/4/18.
 */
public class WeightedUF {
    private int[] id;
    private int count;
    private int[] sz;
    public WeightedUF(int N){
        id = new int[N];
        sz = new int[N];
        count = N;
        for(int i = 0; i < N ;i++) id[i] = i;
        for(int i = 0; i < N ; i++) sz[i] = i;
    }
    public int count(){return count;
    }
    public int find(int i){
        while(i != id[i]) i = id[i];
        return i;
    }
    public boolean isConnect(int i, int j){return find(i) == find(j);}
    //lgN的复杂度，就是让树变的更平衡了
    public void union(int i, int j){
        int iRoot = find(i);
        int jRoot = find(j);
        if(iRoot == jRoot) return;
        if(sz[iRoot] < sz[jRoot]) {
            id[iRoot] = id[jRoot];
            sz[jRoot] += sz[iRoot];
        }else{
            id[jRoot] = id[iRoot];
            sz[iRoot] += sz[jRoot];
        }
        count--;
    }
}
