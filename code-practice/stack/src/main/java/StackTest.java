public class StackTest {

	public static void main(String args[]) {
		
		Stack1 st = new Stack1();
		st.push("q");
		st.push("a");
		st.push("b");

		System.out.println(st.pop());
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
