package array;

/**
 * Created by batraa on 4/19/2015.
 *
 * Input 4 5 2 25
 * Output 5 25 25 -1
 *
 * Input 13 7 6 12
 * Output -1 12 12 -1
 */
public class FindNextGreaterElementToRight {

    public static void main(String[] args) {

        int [] arr = {4,5,2,25};
        FindNextGreaterElementToRight obj = new FindNextGreaterElementToRight();
        obj.printNextGreaterElementToRight(arr);

    }

    private void printNextGreaterElementToRight(int[] arr) {

        for(int i=0; i < arr.length -1; i++) {

            int next = -1;
            for(int j = i+1; j < arr.length  ; j ++) {
                if(arr[j] < arr[i]) {
                    continue;
                }
                else {
                    next = arr[j];
                    System.out.println(next);
                    break;
                }
            }

        }

        System.out.println("-1");
    }


}
