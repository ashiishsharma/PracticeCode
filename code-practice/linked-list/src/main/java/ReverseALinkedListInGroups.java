public class ReverseALinkedListInGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList lst = new LinkedList();
		lst.addNode("4");
		lst.addNode("2");
		lst.addNode("6");
		lst.addNode("8");

		lst.traverse();

		// k is group size soop should be 2 4 8 6
		Node head = reverse(lst.getHead(), 2);
		System.out.println("Reverse list");
		while (head != null) {
			System.out.println(head.getData());
			head = head.next;
		}

	}

	private static Node reverse(Node head, int k) {

		Node current = head;
		Node next = null;
		Node prev = null;
		int count = 0;

		/* reverse first k nodes of the linked list */
		while (current != null && count < k) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null) {
			Node rev = reverse(next, k);
			head.setNext(rev);
		}
		/* prev is new head of the input list */
		return prev;

	}

}
