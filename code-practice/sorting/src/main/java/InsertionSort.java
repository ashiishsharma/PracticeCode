/**
 * 
 * 5 9 2 3
 * 
 * it has a concept of 2 sub-arrays left and right
 * left starts with one element and as and when elements from right are added 
 * they are inserted in the left sub-array at the right position
 * 
 *  5 : 9 2 3
 *  9 is added to left sub-array
 *  5 9: 2 3 
 *  2 is added to left sub-array
 *  2 5 9: 3
 *  3 is added to left sub-array
 *  2 3 5 9:
 *
 *  Shell sort is kind of insertion short but it is done for different spans like 7 3 and 1 separately
 *  First for items in array in gap of 7 then 3 then 1 that ways fewer exchanges will be required
 *  
 */
public class InsertionSort {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer a[] = new Integer[] {23,45,67,32,56,12,1,5,78};
		
		InsertionSort.sort(a);

		trace(a);
		
	}

	private static void trace(Integer[] a) {
		for(Integer i: a) {
			System.out.println(i);
		}
	}

	private static void sort(Integer[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) { //1 2 3 is a[i], considering a[0] as sorted
			for (int j=i-1;j>=0;j--){ // a[0] traversing back from i-1 to 0 in this array 
				if(a[j+1]<a[j]) { // a[1] < a[0] // exchanging along the way
					exchange(a, j+1, j);
				}
			}
		}
	}

	private static void exchange(Integer[] a, int i, int smallestIndex) {

		int temp = a[smallestIndex];
		a[smallestIndex] = a[i];
		a[i] = temp;
	}

}
