package recursion;

/**
 * Given a sequence, find the length of the longest palindromic subsequence in it. For example, if the given sequence
 * is “BBABCBAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
 */
public class LongestPlanidromeSequence {

    public  static  void main (String args[]) {

        LongestPlanidromeSequence obj = new LongestPlanidromeSequence();
        String s = "BBABCBAB";

        char[] seq = s.toCharArray();

        System.out.println(" Length of longest seq is "+ obj.findLongestPlanidromeSequence(seq, 0,  s.length()-1));



    }

    private int findLongestPlanidromeSequence(char[] seq, int i, int j) {

        // Base Case 1: If there is only 1 character
        if (i == j)
            return 1;

        // Base Case 2: If there are only 2 characters and both are same
        if (seq[i] == seq[j] && i + 1 == j)
            return 2;

        // If the first and last characters match
        if (seq[i] == seq[j])
            return findLongestPlanidromeSequence(seq, i + 1, j - 1) + 2;

        // If the first and last characters do not match
        return max( findLongestPlanidromeSequence(seq, i, j - 1), findLongestPlanidromeSequence(seq, i + 1, j) );

    }

    private int max(int i, int j) {
        return ((i>j)?i:j);
    }


}
