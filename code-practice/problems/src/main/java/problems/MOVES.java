package problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://www.codechef.com/problems/MOVES
 * 
 *
 */
public class MOVES {

	static Set<String> set = new HashSet<String>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "rdrddr";
		Pattern p = Pattern.compile("r*"); 
	    Matcher m = p.matcher(str);
	    System.out.println(m.matches());
	    
		 // Create an alphabet to work with
        char[] alphabet = new char[] {'r','d'};
        // Find all possible combinations of this alphabet in the string size of 3
        StringExcersise.possibleStrings(6, alphabet,"");
        
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
        	String string = iter.next();
        	if(containsMoreThan(string, 'r',3) || containsMoreThan(string, 'd',3))
        	{
        		iter.remove();
        	}
        	else
        	{
        		System.out.println(string);
        	}
        }
        
        
	}

	
	private static boolean containsMoreThan(String string, char string2, int threshold) {

		int count=0;
		for(int i = 0 ; i < string.length() ; i ++) {
			if(string.charAt(i) == string2) {
				count ++;
			}
		}
		if(count> threshold) {
		return true;
		}
		return false;
	}


	static class StringExcersise {

	    public static void possibleStrings(int maxLength, char[] alphabet, String curr) {

	        // If the current string has reached it's maximum length
	        if(curr.length() == maxLength) {
	        	set.add(curr);
//	            System.out.println(curr);

	        // Else add each letter from the alphabet to new strings and process these new strings again
	        } else {
	            for(int i = 0; i < alphabet.length; i++) {
	                String oldCurr = curr;
	                curr += alphabet[i];
	                possibleStrings(maxLength,alphabet,curr);
	                curr = oldCurr;
	            }
	        }
	    }
}
}