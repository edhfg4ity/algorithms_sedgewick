package graph_theory.union_find;

/**
 * Created by Vincent on 2016/4/18.
 * Union-find 不相交集
 */
public class UF {
    private int[] id;
    private int count;
    public UF(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i< N; i++)
            id[i] = i;
    }
    public int count(){return count;}
    //复杂度太高，union每次都要扫描整个数组
    public boolean isconnect1(int i , int j){return find(i) == find(j);}
    public int find(int i){return id[i];}
    //O(N)
    public void union(int i, int j){
        if(id[i] == id[j]) return;
        for(int w = 0; w < id.length; w++)
            if(id[w] == id[i]) id[w] = id[j];
        count--;
    }
    //不用每次都扫描这个id数组，但最差情况下也要扫描整个数组
    public boolean isconnect2(int i, int j){
        return find2(i) == find2(j);
    }
    public int find2(int i){
        while(i != id[i]) i = id[i];
        return i;
    }
    //O(树的高)
    public void union2(int i, int j){
        int iRoot = find2(i);
        int jRoot = find2(j);
        if(iRoot == jRoot) return;
        id[iRoot] = id[jRoot];
        count--;
    }
}
