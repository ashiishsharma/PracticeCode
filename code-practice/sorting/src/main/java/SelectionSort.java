/**
 * 
 * 5 9 2 3
 * i
 * select smallest and replace with left most then left most is sorted
 * 2 9 5 3
 *   i
 * then increment i and repeat till we go to end  
 * 2 3 9 5
 *     i 
 */
public class SelectionSort {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer a[] = new Integer[] {23,45,67,32,56,12,1,5,78};
		
		SelectionSort.sort(a);

		trace(a);
		
	}

	private static void trace(Integer[] a) {
		for(Integer i: a) {
			System.out.println(i);
		}
	}

	private static void sort(Integer[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int smallestIndex = findSmallestNumberIndex(i,a);
			exchange(a, i, smallestIndex);
		}
		
	}

	private static void exchange(Integer[] a, int i, int smallestIndex) {
		int temp = a[smallestIndex];
		a[smallestIndex] = a[i];
		a[i] = temp;
	}

	private static int findSmallestNumberIndex(int i, Integer[] a) {
		int n = a.length;
		int smallestIndex=i;
		int smallest = a[i++];
		
		for (;i<n;i++) {
			if(a[i]<smallest) {
				smallest=a[i];
				smallestIndex=i;
			}
		}
		return smallestIndex;
	}

}
