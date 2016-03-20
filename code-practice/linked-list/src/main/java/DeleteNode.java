/**
 * Delete a node from a singly linked list given only access to that node
 * i/p node c from a-> b-> c->d->e
 * o/p a->b->d->e
 * we are not given access to head of linkedlist we are given access 
 * to c and we have to delete it so only way is to copy data oh ahead nodes 
 * d to c 
 * e to d
 * and e-> next as null
 *
 */
public class DeleteNode {

	
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.addNode("a");
		list.addNode("b");
		list.addNode("c");
		list.addNode("d");
		list.addNode("e");
		list.traverse();
		
	}

}
