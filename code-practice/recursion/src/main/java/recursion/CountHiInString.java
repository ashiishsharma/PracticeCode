package recursion;

public class CountHiInString {

	/**
	 * Count occurences of Hi in a string recursively
	 */
	public static void main(String[] args) {

		CountHiInString countHiInString = new CountHiInString();
		System.out.println(countHiInString.countHiInString("HiABCHi",0));
		System.out.println(countHiInString.countHiInString("HiABC",0));
		System.out.println(countHiInString.countHiInString("ABC",0));
		System.out.println(countHiInString.countHiInString("HiHiHi",0));
	}

	private int countHiInString(String str, int count) {

		if (str.startsWith("Hi")) {
			count = count+1;
			return countHiInString(str.substring(2), count);
		} else if(str.equals("")) {
			return count;
		} else {
			return 	countHiInString(str.substring(1), count);
		}
	}
}
