import java.util.Iterator;
import java.util.LinkedList;

public class RemoveDuplicatesFromUnsortedLinkedList {

	
	/**
	 * @param args
	 * i/p 25 43 2 25 4
	 * o/p 25 43 2 4
	 * 
	 * Use another linked list and check 
	 * another option is to use LinkedHashSet
	 */
	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(25);
		list.add(43);
		list.add(2);
		list.add(25);
		list.add(4);
		
		System.out.println(" before removing");
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			System.out.println(i);
		}
		
		list = removeDuplicates(list);
		System.out.println(" after removing");
		 iter = list.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			System.out.println(i);
		}



	}

	private static LinkedList<Integer> removeDuplicates(LinkedList<Integer> head) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		Iterator<Integer> iter = head.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			if(!list.contains(i)) {
				list.add(i);
			}
		}

		return list;
	}

}
