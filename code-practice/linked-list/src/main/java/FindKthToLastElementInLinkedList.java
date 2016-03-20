import java.util.Iterator;
import java.util.LinkedList;

/**
 * Find length of list and then traverse again till length -k
 *
 * Alternate soln is to keep 2 pointers k distance apart 
 * and forward them till ahead one reaches null
 *
 *Another alternate is recursion
 *25 43 2 25 4
 */
public class FindKthToLastElementInLinkedList {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(25);
		list.add(43);
		list.add(2);
		list.add(25);
		list.add(4);
		
		System.out.println(" Printing List ");
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			System.out.println(i);
		}
		
	//prints 25	
		printKthToLastElement(list,1);
		//prints 2
		printKthToLastElement(list,2);
		//prints 43
		printKthToLastElement(list,3);
	}

	private static void printKthToLastElement(LinkedList<Integer> list, int k) {

		int length = 0;
		Iterator<Integer> iter = list.iterator();
		//Find length of the list
		while(iter.hasNext()) {
			Integer i = iter.next();
			length ++;
		}
		
		int i = 0;
		int val =0;
		iter = list.iterator();
		while(i++ < length -k) {
			  val = iter.next();
		}
		System.out.println(k + "th to the Last Element is "+val);
		
	}
	
//	private static int recurseKthToLastElement(LinkedList<Integer> list, int k, int count) {
//
//		int length;
//		
//		if(list==null) {
//			length = count;
//		}
//		
//		if(k == length - count) {
//			
//		}
//		
//		int i = recurseKthToLastElement(list.next, k)+1;
//		if(k == i) {
//			System.out.println(list.data);
//		}
//		
//	}
}
