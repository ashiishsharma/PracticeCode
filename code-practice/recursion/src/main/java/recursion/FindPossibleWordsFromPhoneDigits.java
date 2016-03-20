package recursion;

import java.util.ArrayList;

/**
 *  if you click 2 possible characters are abc 2 -> abc, 3 - > def , 4 -> ghi
 *
 * If you dial 234 then combinations should be adg adh adi aeg aeh etc
 */
public class FindPossibleWordsFromPhoneDigits {


    public static void main(String args[]) {

        // if you click 2 possible characters are abc 2 -> abc, 3 - > def , 4 -> ghi
        String[] keyPadHashTable = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int numberDialled[] = {2, 3, 4};

        FindPossibleWordsFromPhoneDigits obj = new FindPossibleWordsFromPhoneDigits();
        ArrayList<String> result = new ArrayList<String>();
        obj.printCombinations(keyPadHashTable, numberDialled, result, 0);
    }

    private void printCombinations(String[] keyPadHashTable, int[] numberDialled, ArrayList<String> result, int currentDigitIndex) {

        if (currentDigitIndex == numberDialled.length) {
            printResult(result);
            System.out.println("--");
            return;
        }

        // Try all 3 possible characters for current digir in number[]
        // and recur for remaining digits
        for ( int i=0; i  < (keyPadHashTable[numberDialled[currentDigitIndex]]).length() ; i++)
        {
            result.add((keyPadHashTable[numberDialled[currentDigitIndex]]).charAt(i)+"");

            printCombinations(keyPadHashTable, numberDialled, result,  currentDigitIndex + 1);

            //Nothing for 0 and 1
            if (numberDialled[currentDigitIndex] == 0 || numberDialled[currentDigitIndex] == 1) {
                return;
            }
        }
    }

    private void printResult(ArrayList<String> result) {

        for(String x: result) {
            System.out.print(x);
        }
    }
}
