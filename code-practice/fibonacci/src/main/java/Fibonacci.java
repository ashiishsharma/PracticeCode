import java.util.HashMap;

public class Fibonacci {

	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 1;
		int b = 1;
		System.out.println(a);
		System.out.println(b);
		printFibonacci(a,b);
//		System.out.println(printRecursiveFibonacci(13));
	}

	private static int printRecursiveFibonacci(int n) {

	 int f;
	 
		if(map.containsKey(n)) {
			return n;
		}
			
		if(n <=2 ) {
			f = 1;
		}
		
		f =  printRecursiveFibonacci(n) + printRecursiveFibonacci(n-1);
		
		map.put(n, f);
		return f;
	}

	private static void printFibonacci(int a, int b) {
		
		int c = a+b;
		System.out.println(c);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printFibonacci(b, c);
		
	}

	
}
