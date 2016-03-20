package array;

public class LargestSumSubContiguousArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		 int n = a.length;
		 int max_sum = maxSubArraySum(a, n);
		 System.out.println("Maximum contiguous sum is %d\n" + max_sum);
	}

	private static int maxSubArraySum(int[] a, int n) {

		int max_so_far = a[0], i;
		   int curr_max = a[0];
		 
		   for (i = 1; i < n; i++)
		   {
		        curr_max = max(a[i], curr_max+a[i]);
		        max_so_far = max(max_so_far, curr_max);
		   }
	   return max_so_far;
	}

	private static int max(int i, int j) {

		if(i>j) { 
			return i;
			} else {
				return j;
			}
	}

}
