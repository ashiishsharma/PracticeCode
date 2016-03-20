package recursion;

public class Count7 {

	/**
	 * 
	 *  count7(717) is 2
	 *	count7(7) is  1
	*	ount7(123)  is 0
	 * 
	 */
	public static void main(String[] args) {

		Count7 count7 = new Count7();
		System.out.println(count7.count7Iteratively(717));
		System.out.println(count7.count7Iteratively(7));
		System.out.println(count7.count7Iteratively(123));
		int count = 0;
		System.out.println(count7.count7Recursively(777, count));
		System.out.println(count7.count7Recursively(7, count));
		System.out.println(count7.count7Recursively(717, count));
		System.out.println(count7.count7Recursively(123, count));
		
	}

	private int count7Iteratively(int n) {
		
		int count = 0;
		
		while(n > 0) {
			int lastInteger = n%10;
			if(lastInteger  == 7) {
				count++;
			}
			n = n/10;
		}
		return count;
	}

	private int count7Recursively(int n, int count) {
		int lastN = n%10;
		if( lastN == 7) {
			count = count+1;
		}
		if(n == 0) {
			return count;
		}
		return count7Recursively(n/10, count);
	}
	
}
