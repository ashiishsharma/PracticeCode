package recursion;


/**Lucky numbers are subset of integers. Rather than going into much theory, let us see the process of arriving at lucky numbers,

Take the set of integers
1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,……

First, delete every second number, we get following reduced set.
1,3,5,7,9,11,13,15,17,19,…………

Now, delete every third number, we get
1, 3, 7, 9, 13, 15, 19,….….

Continue this process indefinitely……
Any number that does NOT get deleted due to above process is called “lucky”.

Therefore, set of lucky numbers is 1, 3, 7, 13,………

Now, given an integer ‘n’, write a function to say whether this number is lucky or not.

    bool isLucky(int n)
    **/

public class LuckyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(isLucky(9));
		System.out.println(isLucky(19));
		System.out.println(isLucky(6));
	}
	
	private static boolean isLucky(int n) {

		int [] arr = new int[n];

		for(int i=0; i < n; i ++) {
			arr[i] = i+1;
		}
		
		int start=2;
		return isLucky(arr,start,n);
	}

	private static boolean isLucky(int[] arr, int start, int n) {

		if(start > n) {
			return true;
		}
		
		int [] newArr = new int[arr.length];
		int pos = 0;
		int j=0;
		for(int i = 0 ; i < arr.length ; i ++) {
			if(i%start-1 != 0) {
				newArr[j++] = arr[i];
				if(n==arr[i]) {
					pos = j;
				}
			}else{
				if(n == arr[i]) {
					return false;
				}
			}
		}
		return isLucky(newArr, start +1, pos);
	}

}
