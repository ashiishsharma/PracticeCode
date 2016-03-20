public class LinkedList {

	Node head;
	
	public Node getHead() {
		return head;
	}

	public void addNode(String data) {
	
		Node n = getNode(data);
		Node top = head;
		if(top == null) {
			head = n;
		}
		else {
			while(top.next != null) {
				top = top.next;
			}
			top.next = n;
		}
		
	}
	
	private Node getNode(String data) {
		Node s = new Node(data, null);
		return s;
	}

	public void removeNode(String data) {

		if(head.data.equals(data)) {
			head = head.next;
		} else {
			Node top = head;
			while(!top.next.data.equals(data)) {
				top = top.next;
			}
			top.next = top.next.next;
		}
	}

	public void traverse() {
		System.out.println(" Traversing List ");
		Node top = head;
		while(top != null) {
			System.out.println(top.data);
			top = top.next;
		}
		
	}
	
	public int size() {
		int count=0;
		Node top = head;
		while(top != null) {
			top = top.next;
			count++;
		}
		return count;
	}
	
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
