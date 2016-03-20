package recursion;

public class ParenBit {

	/**
	 * Given a string that contains a single pair of parenthesis, 
	 * compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)". 
	 * 
	 * parenBit("xyz(abc)123") is "(abc)"
		parenBit("x(hello)") is "(hello)"
		parenBit("(xy)1") is "(xy)"
	 */
	public static void main(String[] args) {
		
		
		ParenBit obj = new ParenBit();
		System.out.println(obj.parenBit("xyz(abc)123",0, ""));
		System.out.println(obj.parenBit("x(hello)",0, ""));
		System.out.println(obj.parenBit("(xy)1",0, ""));
	}

	private String parenBit(String str, int index, String result) {

		char ch = str.charAt(index);

		result = result + ch;
		
		if(ch == ')') {
			return result;
		}

		if(ch == '(') {
			result = ""+ch;
		}
		
		return parenBit(str, index+1, result);
	}

}
