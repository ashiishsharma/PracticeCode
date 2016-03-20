package recursion;

/**
 * Created by batraa on 4/10/2015.
 */
public class ReverseAString {


    public static void main(String[] args) {
        reverse("abc");
    }

    private static void reverse(String str) {

        reverse(str, str.length()-1);
    }

    private static void reverse(String str, int i) {
        System.out.print(str.charAt(i));
        if(i!=0){
            reverse(str, i-1);
        }
    }


}
