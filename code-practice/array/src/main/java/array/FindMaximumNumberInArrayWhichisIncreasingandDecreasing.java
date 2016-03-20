package array;

/**
 * Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.

 Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
 Output: 500

 Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
 Output: 50

 Corner case (No decreasing part)
 Input: arr[] = {10, 20, 30, 40, 50}
 Output: 50

 Corner case (No increasing part)
 Input: arr[] = {120, 100, 80, 20, 0}
 Output: 120
 */
public class FindMaximumNumberInArrayWhichisIncreasingandDecreasing {


    public static void  main(String args[]) {

        int arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        FindMaximumNumberInArrayWhichisIncreasingandDecreasing obj = new FindMaximumNumberInArrayWhichisIncreasingandDecreasing();
        int max = obj.findMaximumNumberInArrayWhichisIncreasingandDecreasing(arr, 0 , arr.length);
        System.out.print("Max element is "+ max);

    }

    /**
     * Using binary search
     * @param arr
     * @return
     */
    private int findMaximumNumberInArrayWhichisIncreasingandDecreasing(int[] arr, int lo, int hi) {


        if(lo == hi) {
            return arr[lo];
        }

        if(hi == lo+1) {
            if(arr[lo] > arr[hi]){
                return arr[lo];
            }else {
                return arr[hi];
            }
        }

        int mid = (lo + hi)/2;

         /* If we reach a point where arr[mid] is greater than both of
     its adjacent elements arr[mid-1] and arr[mid+1], then arr[mid]
     is the maximum element*/
        if ( arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            return arr[mid];
        }

         /* If arr[mid] is greater than the next element and smaller than the previous
    element then maximum lies on left side of mid */
        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
            return findMaximumNumberInArrayWhichisIncreasingandDecreasing(arr, lo, mid - 1);
        }else { // when arr[mid] is greater than arr[mid-1] and smaller than arr[mid+1]
            return findMaximumNumberInArrayWhichisIncreasingandDecreasing(arr, mid + 1, hi);
        }
    }


}
