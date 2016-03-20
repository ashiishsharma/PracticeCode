package array;

public class CircularShift {

	/**
	 * CircularShift using least time and space complexity
	 * int[] array = {1,2,3,4,5,6,7,8};
    	leftShift( array, 3);
    	
    	O/P [4, 5, 6, 7, 8, 1, 2, 3]
	 */
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		CircularShift cs = new CircularShift();
		cs.leftShift( array, 3);

		for(int x:array) {
			System.out.print(x + " ");
		}
	}

	private void leftShift(int[] array, int n) {
		
		for (int shift = 0; shift < n; shift++) {
	        int first = array[0]; //1 2 3
	        System.arraycopy( array, 1, array, 0, array.length - 1 );
	        // 2 3 4 5 6 7 8 
	        array[array.length - 1] = first;
	        // 2 3 4 5 6 7 8 1
	    }
	}

}
