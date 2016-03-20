/**
 * Merge Sort
 * 
 *  If we have 2 sorted arrays and we need to merge them together
 *  5   9 and   3  6
 *  lo         mid hi
 *  
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Integer a[] = new Integer[] {23,45,67,32,56,12,1,5,78};
		//copy of array a 
		Integer aux[] = new Integer [] {23,45,67,32,56,12,1,5,78};
		
		sort(a,aux,0,a.length-1);

		trace(a);
	}

	

	private static void trace(Integer[] a) {
		for(Integer i: a) {
			System.out.println(i);
		}
	}

	
	private static void sort(Integer[] a, Integer[] aux, int lo, int hi) {


		if(hi<=lo) return;
		
		int mid = lo+ (hi-lo)/2;
		
		//sort left half
		sort(a,aux, lo,mid);
		
		//sort right half
		sort(a,aux, mid+1,hi);
		
		//merge
		merge(a,aux,lo,mid,hi);
	}


	public  static void merge (Integer[] a, Integer[] aux,  int lo, int mid, int hi) {
	
		//Copy array into aux
		for(int k =lo;k<hi;k++) {
			aux[k] = a[k];
		}
		//traverse the array Copy elements from aux into a in sorted order whichever is smaller first 
		//ik lo     mid j   hi
		for (int i=lo, j=mid+1,k=lo; k<=hi; k++) {
			
			if(i>mid) {
				a[k] = aux[j++];
			}
			else if(j>hi) {
				a[k] = aux[i++];
			}
			else if(aux[i] < aux[j]) {
				a[k]=aux[i++];
			} else
			{
				a[k]=aux[j++];
			}
				
		}//end of for loop
		
		
	}
}
