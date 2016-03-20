package array;

/**
 * i/p aabbbcccc o/p will be a2b3c4
 * i/p abcdde o/p will be a1b1c1d2e1 
 * @author batraa
 *
 */
public class StringCompression {

	static String compressString(String str1) {
		int [] charCount = new int[256] ;
		
		char[] charArr = str1.toCharArray();
		for(char ch:charArr ) {
			charCount[Integer.valueOf(ch)] = charCount[Integer.valueOf(ch)] + 1;
 		}
		
		StringBuilder op = new StringBuilder();
		
	
		char oldCh = 0;
		for (int i = 0 ; i < str1.length(); i++) {

			char ch = str1.charAt(i);		
			if(ch != oldCh) {
				op.append(ch).append(charCount[Integer.valueOf(ch)]);
				oldCh = ch;
			}
		}
		
		return op.toString();
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		System.out.println(compressString("aabbbcccc"));
		System.out.println(compressString("abcdde"));
	}

}
