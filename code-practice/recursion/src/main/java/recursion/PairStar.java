package recursion;

public class PairStar {

	/**
	 * Given a string, compute recursively a new string where identical chars that are adjacent 
	 * in the original string are separated from each other by a "*". 
	 * 
	 * pairStar("hello") ? "hel*lo"
		pairStar("xxyy") ? "x*xy*y"
		pairStar("aaaa") ? "a*a*a*a"
	 */
	public static void main(String[] args) {

		PairStar obj = new PairStar();
		System.out.println(obj.pairStar("hello", 0, ""));
		System.out.println(obj.pairStar("xxyy", 0, ""));
		System.out.println(obj.pairStar("aaaa", 0, ""));
		
	}

	private String pairStar(String string, int index, String result) {

		char ch = string.charAt(index);
		
		if(result.length() >= 1 && result.substring(result.length() -1, result.length()).equals(ch+"")) {
			result = result + "*";
			result = result+ch;
//			 return pairStar(string, index+1, result+"*");
		}else{
			result = result+ch;
		}
		
		if(index == string.length() -1) {
			return result;
		}
		
		return pairStar(string, index+1, result);
	}

}
