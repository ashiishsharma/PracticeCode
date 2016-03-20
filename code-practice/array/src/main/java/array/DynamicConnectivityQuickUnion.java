package array;

/**
 * Created by batraa on 1/2/2015.
 */

//Tree concepts but trees can grow tall increasing time more
    //Weighted quick union improvement over this where smaller tree goes below always union time logn
public class DynamicConnectivityQuickUnion {

    int arr[];

    public DynamicConnectivityQuickUnion(int n) {
        arr = new int[n];
        for(int i=1;i<n;i++){
            arr[i] = i;
        }
    }

    public void union(int p, int q) {

        if(!isConnected(p,q)) {
            int i = root(p);
            int j = root(q);
            arr[i] = j;
        }
    }

    public boolean isConnected(int p, int q) {
        return (root(p) == root(q));
    }

    private int root(int p) {

        int tempLoc =p;
        int tempVal = arr[p];

        while(tempLoc!=tempVal) {
            tempLoc = tempVal;
            tempVal = arr[tempLoc];
        }
        return tempVal;
    }

    public static void main(String args[]) {
        System.out.println("QuickOne");
        DynamicConnectivityQuickUnion dc = new DynamicConnectivityQuickUnion(10);
        dc.union(4,3);
        dc.union(3,8);
        dc.union(6,5);
        dc.union(9,4);
        dc.union(2,1);
        dc.union(8,9);
        System.out.println("Is connected 5 and 0 " + dc.isConnected(5, 0));
        dc.union(5, 0);
        System.out.println("Is connected 5 and 0 " + dc.isConnected(5,0));
        dc.union(7,2);
        dc.union(6,1);
        dc.union(1,0);
        dc.union(6,7);
        System.out.println("Is connected 0 and 8 " + dc.isConnected(0,8));
        System.out.println("Is connected 7 and 3 " + dc.isConnected(7,3));
        System.out.println("Is connected 7 and 2 " + dc.isConnected(7,2));


    }
}
