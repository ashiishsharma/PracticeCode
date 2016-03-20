package recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrintAllCombinationsOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintAllCombinationsOfString obj = new PrintAllCombinationsOfString();
		
		obj.printAllCombinationsOfString("abc");
		

	}

	private void printAllCombinationsOfString(String string) {
		Set<String> set = printAllCombinations(string);
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

	public static Set<String> printAllCombinations(String input)
	{
	    Set<String> set = new HashSet<String>();
	    if (input == "")
	        return set;
 
	    Character a = input.charAt(0);

	    if (input.length() > 1)
	    {
	        input = input.substring(1);

	        Set<String> permSet = printAllCombinations(input);

	        for (String x : permSet)
	        {
	            for (int i = 0; i <= x.length(); i++)
	            {
	                set.add(x.substring(0, i) + a + x.substring(i));
	            }
	        }
	    }
	    else
	    {
	        set.add(a + "");
	    }
	    return set;
	}
	

}
