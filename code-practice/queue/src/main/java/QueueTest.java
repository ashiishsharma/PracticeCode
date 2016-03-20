public class QueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Queue qu = new Queue();
		qu.enqueue("a");
		qu.enqueue("b");
		qu.enqueue("c");
		
		System.out.println(qu.dequeue());
		System.out.println(qu.dequeue());
		System.out.println(qu.dequeue());
	}

}
