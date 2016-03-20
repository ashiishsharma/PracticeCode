package array;

/**
 * Created by batraa on 5/6/2015.
 */
public class RevereseArray {

    public static void main (String[] args) {

        int arr[] = {2,5,4,9,10};

        RevereseArray obj = new RevereseArray();
        obj.reverseArray(arr);
        obj.printArray(arr);

    }

    private void reverseArray(int[] arr) {

        int start = 0 ;
        int end = arr.length-1;

        while(start < end) {

            exchange(arr, start, end);
            start = start+1;
            end = end - 1;
        }
    }

    private void exchange(int[] arr, int start, int end) {

        int temp = arr[start];
        arr[start]= arr[end];
        arr[end] = temp;
    }

    private void printArray(int[] arr) {

        for(int x: arr){
            System.out.println(x);
        }
    }

}
