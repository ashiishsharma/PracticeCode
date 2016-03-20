/**
 * LIFO impl
 *
 */
public class Stack1 {

	Node top = null;
	
	public void push(String  data) {
		
		Node n = getNode(data);
		if(top==null) {
			top = n; 
			return;
		}
		
		n.next = top;
		top=n;
	}
	
	private Node getNode(String data) {
		Node n = new Node(data, null);
		return n;
	}

	public String pop() {
		
		String data = top.data;
		top = top.next;
		return data;
	}
	
	public String peek() {
		return top.data;
	}
}
