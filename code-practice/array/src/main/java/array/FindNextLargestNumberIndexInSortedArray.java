package array;

/**

 Given a sorted array and a number find the index of the number which is just larger than the given number in the array
 Find O (n) solution and O (nlogn) solution
 */
public class FindNextLargestNumberIndexInSortedArray {


    public static void  main (String[] args) {

        FindNextLargestNumberIndexInSortedArray obj = new FindNextLargestNumberIndexInSortedArray();

        int[] arr = new int[]{1, 4, 5, 6, 9};
        int number = 6;
        int index = obj.findNextLargestNumberIndexInSortedArray(arr, number);
        if(index!=-1) {
            System.out.println(" Index is " + index);
        }else {
            System.out.println("No index found");
        }

        index = obj.findNextLargestNumberIndexInSortedArrayOptimally(arr, number, 0 , arr.length-1);
        if(index <= arr.length-1) {
            System.out.println(" Optimal Index is " + index);
        }else {
            System.out.println("No Optimal index found");
        }
    }

    private int findNextLargestNumberIndexInSortedArray(int[] arr, int a) {

        int loc = -1;
        for(int i=0;i<arr.length; i++){
            if(arr[i] == a && i != arr.length-1){
                loc = i+1;
            }
        }
        return loc;
    }



    private int findNextLargestNumberIndexInSortedArrayOptimally(int[] arr, int k, int start, int end) {

        int mid = start + ((end-start)/2) ;
        if(arr[mid] == k) {
            return mid+1;
        }

        if(k < arr[mid]) {
            return findNextLargestNumberIndexInSortedArrayOptimally(arr, k, start,mid-1);
        }else{
            return findNextLargestNumberIndexInSortedArrayOptimally(arr, k, mid+1,end);
        }
    }
}
