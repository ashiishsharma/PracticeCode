import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by batraa on 1/8/2015.
 */
public class MinPQ<Key extends Comparable<Key>> {

    Key pq[];
    int N=0;

    public MinPQ(int capacity) {
        //capacity + 1 as we dont use position 0
        pq= (Key[]) new Comparable[capacity+1];
    }

    public MinPQ(Class<Key> clazz,int capacity) {
        pq=(Key[]) Array.newInstance(clazz, capacity);
    }

    public void insert(Key item) {
        //add to the end
        pq[++N] = item;
        //swim that up if it is less than parent
        swim(N);
    }

    // If Child is larger swim up
    private void swim(int k) {
        //log n compares as it is binary tree
        while(k>1 && less(k/2,k)){
            exch(k,k/2);
            k=k/2;
        }
    }

    //If parent becomes smaller then sink it down by replacing it with larger of the 2 children
    private void sink(int k){

        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k=j;
        }
    }


    private void exch(int a, int b) {
        Key temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    private boolean less(int a, int b) {
        if( pq[a].compareTo(pq[b]) <0) {
            return true;
        }
        return false;
    }

    public int size() {
        return N;
    }

    public Key delMin() {
    return null;
    }

    public boolean isEmpty() {
        return N==0;
    }

    //Exchange root which is max with last node i and then sink it down
    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null; // size goes down by 1
        return max;

    }
}
