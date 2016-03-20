import java.util.Stack;

/**
 * i/p 0->1->2->1->0
 * o/p true
 * 
 *  i/p 0->1->2->1
 *  o/p false
 *  
 *
 */
public class CheckIfListIsPlanidrome {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.addNode("0");
		list.addNode("1");
		list.addNode("2");
		list.addNode("1");
		list.addNode("0");
		list.traverse();
		
		System.out.println(isListPlanidrome(list));
		
		LinkedList list1 = new LinkedList();
		list1.addNode("0");
		list1.addNode("1");
		list1.addNode("2");
		list1.addNode("1");
		System.out.println(isListPlanidrome(list1));
		
		
		LinkedList list2 = new LinkedList();
		list2.addNode("0");
		list2.addNode("1");
		list2.addNode("1");
		list2.addNode("0");
		System.out.println(isListPlanidrome(list2));
		
	}

	private static boolean isListPlanidrome(LinkedList list) {
		int size = list.size();
		
		Node head = list.getHead();
		Node start = list.getHead();
		int count=0;
		while(count++ < size/2) {
			head = head.next;
		}
		
		if(size%2 !=0) {
			head = head.next;
		}
		
		Stack<String> stack = new Stack<String>();
		while(head != null) {
			stack.push(head.data);
			head = head.next;
		}
		
		LinkedList reverse = new LinkedList();
		while(!stack.isEmpty()) {
			reverse.addNode(stack.pop());
		}
		Node reverseHead = reverse.getHead();
		while(reverseHead != null) {
			if(!start.data.equals(reverseHead.data)) {
				return false;
			}
			reverseHead = reverseHead.next;
			start = start.next;
		}
		return true;
	}
}
