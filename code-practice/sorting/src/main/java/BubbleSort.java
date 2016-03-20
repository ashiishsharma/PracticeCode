/**
 * 
 * 5 9 2 3
 * compare 5 9
 * no change
 * compare 9 2
 * change 5 2 9 3
 * compare 9 and 3 
 * 5 2 3 9
 * 9 gets bubbled up and is sorted, now we have to sort 5 2 3 remaining array  
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer a[] = new Integer[] {23,45,67,32,56,12,1,5,78};
		
		BubbleSort.sort(a);

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
			for(int j = 0; j < n - i - 1; j++) { 
				if(a[j] > a[j+1]) {
					exchange(a, j, j+1);		
				}
			}
		}
		
	}

	private static void exchange(Integer[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

}
