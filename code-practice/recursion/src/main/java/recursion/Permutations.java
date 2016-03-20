package recursion;

import java.util.HashSet;
import java.util.Set;

public class Permutations {

	/**
	 * Print all permutations of a string 
	 * abc
	 * 
	 * abc bca cab cba bac acb
	 * 
	 */
	public static void main(String[] args) {
		
		Set<String> set = generatePerm("abc");
		
		for(String x: set)
		{
			System.out.println(x);
		}
	}

	
	public static Set<String> generatePerm(String input)
	{
	    Set<String> set = new HashSet<String>();
	    if (input == "")
	        return set;

	    Character a = input.charAt(0);

	    if (input.length() > 1)
	    {
	        input = input.substring(1);

	        Set<String> permSet = generatePerm(input);

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
