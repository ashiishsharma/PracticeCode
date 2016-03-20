package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by batraa on 4/19/2015.
 * <p>
 * Input :  {{1,3}, {2,4}, {5,7}, {6,8} }
 * Output :  {{1,4}, {5,8} }
 */
public class MergeOverlappingIntervals {


    public static void main(String[] args) {

        List<Interval> lst = new ArrayList<Interval>();
        lst.add(new Interval(1, 3));
        lst.add(new Interval(5, 7));
        lst.add(new Interval(2, 4));
        lst.add(new Interval(6, 8));


        Collections.sort(lst);

        System.out.println("Printing list ");
        printList(lst);

        System.out.println("isThereAnOverlap " + isThereAnOverlap(lst));

        System.out.println("Merging overlapping intervals");
        lst = mergeIntervals(lst);

        System.out.println("Printing list ");
        printList(lst);

    }

    private static List<Interval> mergeIntervals(List<Interval> lst) {

        List<Interval> newList = new ArrayList<Interval>();
        newList.add(new Interval(lst.get(0).getStart(), lst.get(0).getEnd()));
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i).getStart() < newList.get(newList.size() - 1).getEnd()) {
                //update end of the previous list
                newList.get(newList.size() - 1).setEnd(lst.get(i).getEnd());
            } else {
                newList.add(new Interval(lst.get(i).getStart(), lst.get(i).getEnd()));
            }
        }
        return newList;
    }

    private static void printList(List<Interval> lst) {
        for (Interval x : lst) {
            System.out.println(x.getStart() + " " + x.getEnd());
        }
    }

    private static boolean isThereAnOverlap(List<Interval> lst) {
        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i).getStart() < lst.get(i - 1).getEnd()) {
                return true;
            }
        }
        return false;
    }

    static class Interval implements Comparable<Interval> {
        private int start;
        private int end;

        public Interval(int x, int y) {
            start = x;
            end = y;
        }

        public int compareTo(Interval o) {
            return this.getStart() - o.getStart();
        }


        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public void setStart(int x) {
            start = x;
        }

        public void setEnd(int x) {
            end = x;
        }
    }
}
