import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 Print the first non repeating number each time you get a new number
 e.g. input 3 2 1 3 2 3
 output     3 3 3 2 1 1

 */
public class FirstNonRepeatingNumber {


    public static void main(String args[]) {


        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(3);
        lst.add(2);
        lst.add(1);
        lst.add(3);
        lst.add(2);
        lst.add(3);

        FirstNonRepeatingNumber obj = new FirstNonRepeatingNumber();
        obj.printFirstNonRepeatingNumber(lst);


    }

    private void printFirstNonRepeatingNumber(ArrayList<Integer> lst) {

        ArrayList<Integer> removalLst = new ArrayList<Integer>();
        LinkedHashSet<Integer> map = new LinkedHashSet<Integer>();
        for(int i:lst) {
            if(removalLst.contains(i)){
                printValue(map);
                continue;
            }

            if(map.contains(i)) {
                map.remove(i);
                removalLst.add(i);
            }else{
                map.add(i);
            }

            printValue(map);

        }

    }

    private void printValue(LinkedHashSet<Integer> map) {
        Iterator<Integer> iter = map.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
            break;
        }
    }

}
