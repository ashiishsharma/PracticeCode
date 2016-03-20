package recursion;

/**
 I/P *  "HE is the One"
 O/P "One the is HE"
 */
public class ReverseWordsInString {

    public static void main(String[] args) {


        String str = reverseWords("HE is the One");

        System.out.print(str);
    }


    /**
     * Iterative
     */
    public static String reverseWords(String sentence) {
        StringBuilder sb = new StringBuilder(sentence.length()+1 );
        String[] words = sentence.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(' ');
        }
        sb.setLength(sb.length() );  // Strip trailing space
        return sb.toString();
    }

}
