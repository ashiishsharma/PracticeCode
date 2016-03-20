/**
 * FIFO impl
 *
 */
public class Queue {

	Node first, last;
	
	public void enqueue(String data) {
		Node n = getNode(data);
		if(first == null && last == null) {
			first = n;
			last=n;
			return;
		}
		
		last.next = n;
		last = last.next;
		
	}
	
	private Node getNode(String data) {
		Node n = new Node(data, null); 
		return n;
	}

	public String dequeue() {
		String data = first.data;
		first = first.next;
		return data;
	}
}
