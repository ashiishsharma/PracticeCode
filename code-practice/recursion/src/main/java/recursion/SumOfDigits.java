package recursion;

public class SumOfDigits {

	/**
	 *  sumDigits(126) is 9
		sumDigits(49) is 13
		sumDigits(12) is 3
	 */
	public static void main(String[] args) {
		
		SumOfDigits sumOfDigits = new SumOfDigits();
		int sum=0;
		System.out.println(sumOfDigits.sumOfDigits(126, sum));
		System.out.println(sumOfDigits.sumOfDigits(49, sum));
		System.out.println(sumOfDigits.sumOfDigits(12, sum));
	}

	private int sumOfDigits(int n, int sum) {
		
		int lastInteger = n %10;
		sum = sum + lastInteger;
		
		if(n==0) {
		return sum;
		}
		
		return sumOfDigits(n/10, sum);
	}

}
