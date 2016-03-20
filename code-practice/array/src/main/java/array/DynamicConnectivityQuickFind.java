package array;

/**
 * Created by batraa on 1/2/2015.
 */
public class DynamicConnectivityQuickFind {

    int arr[];

    public DynamicConnectivityQuickFind(int n) {
        arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i] = i;
        }
    }

    public void union(int p, int q) {

        if (!isConnected(p, q)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr[p]) {
                    arr[i] = arr[q];
                }

            }
        }
    }

    public boolean isConnected(int p, int q) {
        return (arr[p] == arr[q]);
    }

    public static void main(String args[]) {
        DynamicConnectivityQuickFind dc = new DynamicConnectivityQuickFind(10);
        dc.union(4, 3);
        dc.union(3, 8);
        dc.union(6, 5);
        dc.union(9, 4);
        dc.union(2, 1);
        dc.union(8, 9);
        System.out.println("Is connected 5 and 0 " + dc.isConnected(5, 0));
        dc.union(5, 0);
        System.out.println("Is connected 5 and 0 " + dc.isConnected(5, 0));
        dc.union(7, 2);
        dc.union(6, 1);
        dc.union(1, 0);
        dc.union(6, 7);
        System.out.println("Is connected 0 and 8 " + dc.isConnected(0, 8));
        System.out.println("Is connected 7 and 3 " + dc.isConnected(7, 3));
        System.out.println("Is connected 7 and 2 " + dc.isConnected(7, 2));

        //Union has quadratic time complexity if we want to run union method on n objects it will take n2 time
        //Refer DynamicConnectivityQuickUnion for tree like implementation

    }
}
