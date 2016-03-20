/**
 * Partition a linkedlist around a value x such that nodes less than that
 * are before and greater than that are after  that node
 * i/p 3 -> 6 -> 2 -> 9 -> 4
 * and Node x is 6
 * o/p 3-> 2 -> 4 -> 6 -> 9
 *
 */
public class PartitionLinkedeList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.addNode("3");
		list.addNode("6");
		list.addNode("2");
		list.addNode("9");
		list.addNode("4");
		list.traverse();
		
		partition(list, 6);
	}

	private static void partition(LinkedList list, int x) {

		LinkedList listBefore = new LinkedList();
		LinkedList listAfter = new LinkedList();
		Node head = list.getHead();
		while(head!=null) {
			int data = Integer.valueOf(head.data);
			if(data<x) {
				listBefore.addNode(head.data);
			} else if (data>x) {
				listAfter.addNode(head.data);
			}
			head = head.next;
		}
		
		Node headBefore = listBefore.getHead();
		while(headBefore.next != null) {
			headBefore = headBefore.next;
		}
		
		Node headAfter = listAfter.getHead();
		Node nodeX = new Node(x+"", headAfter);
		headBefore.next=nodeX;
		listBefore.traverse();
	}

}
