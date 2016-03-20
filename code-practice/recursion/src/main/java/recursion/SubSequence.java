package recursion;

/**
 * 
 * Input: str1 = "AXY", str2 = "ADXCPY"
Output: True (str1 is a subsequence of str2)

Input: str1 = "AXY", str2 = "YADXCP"
Output: False (str1 is not a subsequence of str2)

Input: str1 = "gksrek", str2 = "geeksforgeeks"
Output: True (str1 is a subsequence of str2)
 * @author batraa
 *
 */
public class SubSequence {

    public static void main(String[] args) {


        char str1[] = new String("gksrek").toCharArray();
        char str2[] = new String("geeksforgeeks").toCharArray();
        int m = str1.length;
        int n = str2.length;

        System.out.println(isSubSequence(str1, str2, m, n));
        System.out.println(isSubSequenceIteratively("gksrek","geeksforgeeks"));
        System.out.println(isSubSequenceIteratively("gz","geeksforgeeks"));
    }

	static boolean isSubSequence(char str1[], char str2[], int m, int n)
	{
	    // Base Cases
	    if (m == 0) return true;
	    if (n == 0) return false;

	    // If last characters of two strings are matching
	    if (str1[m-1] == str2[n-1])
	        return isSubSequence(str1, str2, m-1, n-1);

	    // If last characters are not matching
	    return isSubSequence(str1, str2, m, n-1);
	}


    static boolean isSubSequenceIteratively(String target, String src) {

        if(src==null) {
            return false;
        }

        if(target==null || target.equals("")) {
            return true;
        }

        if(src.length()<target.length()) {
            return false;
        }
        char[] targetArr = target.toCharArray();
        int k = 0;

        for(char x: targetArr) {
            src = src.substring(k,src.length());
            k = src.indexOf(x);
            if(k==-1){
                return false;
            }
        }
        return true;
    }
	
}
