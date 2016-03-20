package array;

/**
 * Given 2 strings we need to check if string 1 is rotation of string 2
 * waterbottle is rotation of erbottlewat
 * You can only use fn isSubStr
 * write a fn which checks if a str2 is rotation of str1
 * <p>
 * If we can use only isSubString API then solution is str2 = str2 + str2
 * and then simply check isSubStr(str2,str1);
 */

public class CheckRotation {


    static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str2.length(); i++) {

            StringBuilder temp = new StringBuilder();
            temp.append(str2.substring(str2.length() - i, str2.length()));
            temp.append(str2.substring(0, str2.length() - i));

            System.out.println("temp " + temp);
            if (str1.equals(temp.toString())) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isRotation("waterbottle", "erbottlewat"));
        System.out.println(isRotation("abcd", "bcdd"));
    }

}
