package array;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 Given a string, find the first non-repeating character in it. For example, if the input string is “GeeksforGeeks”,
 then output should be ‘f’ and if input string is “GeeksQuiz”, then output should be ‘G’.
 */
public class FindFirstNonRepeatingCharacterInString {

    public static void main(String args[]) {

        FindFirstNonRepeatingCharacterInString obj = new FindFirstNonRepeatingCharacterInString();
        System.out.println(obj.findFirstNonRepeatingCharacterInString("GeeksforGeeks"));
        System.out.println(obj.findFirstNonRepeatingCharacterInString("GeeksQuiz"));
    }

    private String findFirstNonRepeatingCharacterInString(String str) {

        if(str.length() == 1) {
            return str;
        }

        char[] arr = str.toCharArray();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>() ;
        for(char x: arr) {
            String str1 = x+"";
            if(map.containsKey(str1)) {
                map.remove(str1);
            }else{
                map.put(str1, 1);
            }
        }

        Set<String> keys = map.keySet();
        Iterator<String> iter =  keys.iterator();
        String toRet = "";
        if(iter.hasNext()){
            toRet = iter.next();
        }else {
            System.out.print("No non repeating character");
        }

        return toRet;
    }
}
