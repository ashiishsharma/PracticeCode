package recursion;

/**
 Consider the following dictionary
 { i, like, sam, sung, samsung, mobile, ice,
 cream, icecream, man, go, mango}

 Input:  ilike
 Output: Yes
 The string can be segmented as "i like".

 Input:  ilikesamsung
 Output: Yes
 The string can be segmented as "i like samsung" or "i like sam sung".
 */
public class WordBreakProblem {


    public static void main(String[] args) {

        String dictionary[] = {"mobile", "samsung", "sam", "sung", "man", "mango",
                "icecream", "and", "go", "i", "like", "ice", "cream"};

        WordBreakProblem obj = new WordBreakProblem();

        System.out.println("Does word break exists in dictionary " + obj.doesWordBreakExists(dictionary, "ilike"));
        System.out.println("Does word break exists in dictionary " + obj.doesWordBreakExists(dictionary, "ilikesamsung"));
        System.out.println("Does word break exists in dictionary " + obj.doesWordBreakExists(dictionary, "iiii"));
        System.out.println("Does word break exists in dictionary " + obj.doesWordBreakExists(dictionary, "izzz"));
    }

    private boolean doesWordBreakExists(String[] dictionary, String word) {

        int size = word.length();

        if (size == 0) {
            return true;
        }

        for (int i = 1; i <= size; i++) {
            if (dictionaryContainsWord(dictionary, word.substring(0, i)) && doesWordBreakExists(dictionary, word.substring(i, size ))) {
                return true;
            }
        }

        return false;
    }



    public boolean dictionaryContainsWord(String [] dictionary, String word) {
        for(String x: dictionary) {
            if(x.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
