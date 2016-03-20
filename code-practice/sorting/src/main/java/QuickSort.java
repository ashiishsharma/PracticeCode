/**
 *
 * 5 7 9 8 4 2 3
 * p i         j
 * 
 * p is pivot which we will place such that right are less than p and left are greater than p and p is in right place
 * and recursively we will sort right and left items
 * 
 * Move i from right to left unless we get a[i]>a[p] value
 * Move j from left to rt unless we get a[j]<a[p] value
 * 
 * 
 * If i < j index then exchange a[i] and a[j]
 * If i > j index they have crossed then replace a[j] with pivot a[p]
 * 
 *  5 3 9 8 4 2 7
 *  p   i     j
 *  
 *  5 3 2 8 4 9 7
 *  p     i j
 *  
 *  5 3 2 4 8 9 7
 *  p     j i
 *  
 *  
 *  4 3 2 5 8 9 7
 *  -----   -------
 */
public class QuickSort {

	
	public static void main(String[] args) {

		Integer a[] = new Integer[] {23,45,67,32,56,12,1,5,78};
		
		qSort(a,0,a.length-1);
		
		trace(a);
	}

	

	private static void qSort(Integer[] a, int lo, int hi) {
		
		if(hi<=lo) return;
		
		int p = partition(a,lo,hi);
		qSort(a,lo,p-1);
		qSort(a,p+1,hi);

	}
	
	private static int partition(Integer[] a, int lo, int hi) {
	
		int i = lo; 
		int j = hi+1;
		
		while(true) {
			while(a[lo] > a[++i]) {
				if(i==hi) break;
				
			}
			while(a[--j] > a[lo]) {

				if(j==lo) break;
			}
			if(i<j) {
				exchange(a,i,j);
			}else{
				break;
			}
		}

		exchange(a,lo,j);
		return j;
			}
	


	private static void exchange(Integer[] a, Integer i, Integer j) {
		
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
		
	}



	private static void trace(Integer[] a) {
		for(Integer i: a) {
			System.out.println(i);
		}
	}

}
