package graph_theory.min_spanning_tree;

import java.util.Iterator;

/**
 * Created by Vincent on 2016/4/18.
 * 基于最小堆的优先级队列
 */
public class MinPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;
    public MinPQ(int minPQ){
        pq = (Key[]) new Comparable[minPQ - 1];
    }
    public MinPQ(Iterable<Key> keys){
        Iterator<Key> ite = keys.iterator();
        while(ite.hasNext()) insert(ite.next());
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void insert(Key k){
        pq[++N] = k;
        swim(N);
    }
    public Key deleteMin(){
        Key min = pq[0];
        swap(0, --N);
        pq[N -1] = null;
        sink(0);
        return min;
    }
    //上浮
    private void swim(int k){
        while(k >= 1){
            int parent = k % 2 == 0 ? (k - 1)/2 : k/2;
            if(less(k,parent)){
                swap(k, parent);
                k = parent;
            }
        }
    }
    //下沉
    private void sink(int k){
        while(2 * k < N){
            int left = 2 * k + 1;
            if(left < N && less(left+1, left)) left++;
            if(less(k, left)) break;
            swap(k, left);
            k = left;

        }
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void swap(int j, int k){
        Key temp = pq[j];
        pq[j] = pq[k];
        pq[k] = temp;
    }
}
