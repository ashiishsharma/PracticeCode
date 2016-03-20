package recursion;

public class PrintAllCombinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 // Create an alphabet to work with
        char[] alphabet = new char[] {'r','d'};
        // Find all possible combinations of this alphabet in the string size of 3
        StringExcersise.possibleStrings(3, alphabet,"");
	}

	
	static class StringExcersise {

	    public static void possibleStrings(int maxLength, char[] alphabet, String result) {

	        // If the current string has reached it's maximum length
	        if(result.length() == maxLength) {
	            System.out.println(result);

	        // Else add each letter from the alphabet to new strings and process these new strings again
	        } else {
	            for(int i = 0; i < alphabet.length; i++) {
	                String temp = result;
	                result += alphabet[i];
	                possibleStrings(maxLength,alphabet,result);
	                result = temp;
	            }
	        }
	    }
}
}