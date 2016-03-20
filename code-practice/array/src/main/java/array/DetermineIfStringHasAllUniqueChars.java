package array;

/**
 * 
 * Determine if a String has all unique chars and u cannot use additional data structure
 *
 */
public class DetermineIfStringHasAllUniqueChars {

	private  static boolean [] isCharPresent ;
	
	static boolean areAllCharactesUniqueIn(String str) {
		isCharPresent = new boolean[75] ;
		char[] charArr = str.toCharArray();
		for(char ch : charArr)
		{
			int pos = Integer.valueOf(ch) - 48;
//			System.out.println(pos);
			if(isCharPresent[pos]) {
				return false;
			} else {
				isCharPresent[pos] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		System.out.println(areAllCharactesUniqueIn("abc"));
		System.out.println(areAllCharactesUniqueIn("abcc"));
		System.out.println(areAllCharactesUniqueIn("abc123"));
		System.out.println(areAllCharactesUniqueIn("abc112"));
		System.out.println(areAllCharactesUniqueIn("abc1ZZ"));
		System.out.println(areAllCharactesUniqueIn("abc1Z"));
		System.out.println(areAllCharactesUniqueIn("AA"));
	}
}
