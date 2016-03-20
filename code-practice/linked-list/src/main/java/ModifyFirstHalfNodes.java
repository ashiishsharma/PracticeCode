public class ModifyFirstHalfNodes {

	/**
	 * Given a singly linked list, modify the value of first half nodes such that 1st node�s new value is equal 
	 * to the last node�s value minus first node�s current value, 2nd node�s new value is equal to the second 
	 * last node�s value minus 2nd node�s current value, likewise for first half nodes.
	 * 
	 * Using extra memory
	 *  2 pointers fast and slow and once fast ones reaches middle start putting in stack 
	 *  pop from stack and traverse and substract first half nodes or till stack is empty
	 */
	public static void main(String[] args) {

		IntegerLinkedList list = new IntegerLinkedList();
		list.addNode(4);
		list.addNode(3);
		list.addNode(2);
		list.addNode(1);
		
		list.traverse();
		
		
	}

}
