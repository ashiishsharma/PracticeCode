public class IntegerLinkedList {

	Node head;
	
	public Node getHead() {
		return head;
	}

	public void addNode(Integer data) {
	
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
	
	private Node getNode(Integer data) {
		Node s = new Node(data, null);
		return s;
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
	
	class Node {

		Integer data;
		Node next;
		
		
		public Node(Integer data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Integer getData() {
			return data;
		}
		public void setData(Integer data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
}
