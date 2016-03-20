package recursion;

public class CountNoOf11InArray {

	/**
	 * Count no. of times 11 comes in an array
	 * array11({1, 2, 11}, 0) is 1
		array11({11, 11}, 0) is 2
		array11({1, 2, 3, 4}, 0) is 0
	 */
	public static void main(String[] args) {
		CountNoOf11InArray obj = new CountNoOf11InArray();
		
		int arr1[] = {1,2,11};
		System.out.println(obj.countNoOf11InArray(arr1,0,0));
		
		int arr2[] = {11,11};
		System.out.println(obj.countNoOf11InArray(arr2,0,0));
		
		int arr3[] = {1,2,3,4};
		System.out.println(obj.countNoOf11InArray(arr3,0,0));
	}

	private int countNoOf11InArray(int[] arr, int index, int count) {


		if(index==arr.length) {
			return count;
		}
		
		if(arr[index] == 11) {
//			count = count +1;
			return countNoOf11InArray(arr, index+1, count+1);
		}
		
		return countNoOf11InArray(arr, index+1, count);
	}

}
