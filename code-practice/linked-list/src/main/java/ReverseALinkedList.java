public class ReverseALinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		LinkedList lst = new LinkedList();
		lst.addNode("4");
		lst.addNode("2");
		lst.addNode("6");
//		lst.addNode("8");
//		
		lst.traverse();

		Node head = reverse(lst.getHead());
		Node temp = head;
		System.out.println("Reverse list");
		while(head != null) {
			System.out.println(head.getData());
			head = head.next;
		}
		
		Node temp1 = reverseRecursively(temp);
		System.out.println("Reverse list");
		while(temp1 != null) {
			System.out.println(temp1.getData());
			temp1 = temp1.next;
		}
	}

	private static Node reverse(Node head) {

		Node prev = null;
		Node current = head;
		Node next = null;
		while(current != null){
			
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			
		}

		return prev;

	}

	//6 -> 2 -> 4 -> null
	static Node reverseRecursively(Node head) {
		
		 // if head is null or only one node, it's reverse of itself.
		  if ( (head==null) || (head.next == null) ) return head;

		  //reverse 4-> null
		  // reverse the sub-list leaving the head node.
		  Node reverse = reverseRecursively(head.next);

		  // head.next still points to the last element of reversed sub-list.
		  // so move the head to end.
		// 2 -> 4 > next = 2-> 4 -> 2->4 (cyclic) and head points to 2 and reverse points to 4
		  head.next.next = head;

		  // point last node to nil, (get rid of cycles) 2 -> 4 we are breaking connection 2-> null so 4->2->null remains
		  head.next = null;
		  return reverse;

	  
	}
	

}
