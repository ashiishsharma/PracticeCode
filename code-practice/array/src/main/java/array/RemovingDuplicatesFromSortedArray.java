package array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 * 1. Sort and traverse and remove duplicates
 * 2. Put in Set which will remove duplicates
 */
public class RemovingDuplicatesFromSortedArray {

    public static void main (String[] args) {

        int arr[] = {1,2,2,3,3,4,4,4,5};
        System.out.println("Remove duplicates  ");
        removeDuplicates(arr);
        System.out.println("Remove duplicates w/o using collection ");
        removeDuplcatesWithoutUsingCollection(arr);
    }

    private static void removeDuplicates(int[] arr) {
        LinkedHashSet set = new LinkedHashSet();
        for(int x:arr){
            set.add(x);
        }

       Iterator iter = set.iterator();

       while(iter.hasNext()) {
           System.out.println(iter.next());
       }
    }

    private static void removeDuplcatesWithoutUsingCollection(int[] arr) {

        Arrays.sort(arr);

        int previous = arr[0];
        System.out.println(previous);
        for(int x: arr) {

            if(previous == x){
                previous = x;
                continue;
            }

            System.out.println(x);
            previous = x;
        }

    }



}
