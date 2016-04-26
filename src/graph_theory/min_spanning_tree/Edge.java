package graph_theory.min_spanning_tree;


/**
 * Created by Vincent on 2016/4/17.
 */
public class Edge implements Comparable<Edge>{
    private int w;
    private int v;
    private double weight;
    public Edge(int w, int v, double weight){
        this.w = w;
        this.v = v;
        this.weight = weight;
    }
    public int either(){
        return v;
    }
    public int other(int vertex){
        return vertex == v ? w : v;
    }
    public double weight(){
        return weight;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.weight < o.weight){
            return -1;
        }else if(this.weight > o.weight){
            return  1;
        }else{
            return 0;
        }
    }
}
