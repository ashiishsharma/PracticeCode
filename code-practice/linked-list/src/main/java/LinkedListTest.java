public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.addNode("abc");
		list.addNode("def");
		list.addNode("123");
		list.addNode("234");
		list.traverse();
		
		list.removeNode("123");
		list.traverse();
		
		list.removeNode("abc");
		list.traverse();
		
	}

}
