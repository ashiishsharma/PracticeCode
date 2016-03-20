package problems;

/**
 * Description

The Infinite Improbability Drive is a wonderful new method of crossing interstellar distances in a few seconds; without all that tedious mucking about in hyperspace.

As the Improbability Drive reaches infinite improbability, it passes through every conceivable point in every conceivable universe almost simultaneously.

In other words, you're never sure where you'll end up or even what species you'll be when you get there.

The starship Heart of Gold was the first spacecraft to make use of the Infinite Improbability Drive. The craft was stolen by then-President Zaphod Beeblebrox at the official launch of the ship, as he was supposed to be officiating the launch.


Even faster than light, the Infinite Improbability Drive allows The Heart of Gold to go anywhere, no matter how improbable.

To function optimally, the Improbability Drive needs to find out total number of arrangements of the prime factors of the distance that it needs to travel. Since this calculation of non-trivial and needs to be calculated in a fraction of time, Zaphod Beeblebrox the Forth has signed up your services to provide an algorithm that can provide this result.

Every integer greater than 1 can be uniquely represented as a product of one or more primes. Several arrangements of the primer factors may be possible. We will ignore all the factors that include 1 since it is not a primer number. 

For example

4	2*2	f(4) = 1
6	2*3, 3*2	f(6) = 2
8	2*2*2	f(8) = 1
14	2*7, 7*2	f(14) = 2
Input

The input would consist of at most 10000 test cases, each on a separate line. Each test case is a positive integer i<2 63. This input would be provided on standard input. The inputs would consist of multiple test cases, terminated by EOF.

Output

The expected output needs to contain the input number n followed by the smallest number k such that f(k)=n separated by a space. So if input was 1, the k would be 4 since f(4)=1, smallest value of k is 4.

Sample Input	Sample Output
1	1 4
2	2 6
3	3 12
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class InfiniteImprobabilityDriver {

	private static final int MAX_NUM_TESTCASES = 10000;
	private static final String DECIMAL = ".";
	private static final String SPACE = " ";
	private  HashMap<Long, Double> resultMap = new HashMap<Long, Double>(); 

	
	public static void main(String[] args) throws Exception {
	
	   long[] input = new long[MAX_NUM_TESTCASES];
	   int numOfTestCases=0;
	   
	   //Reading input and storing in the input array
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String line = null;
       while( ( ( line=br.readLine()) != null) && !(line.trim().length() == 0) ) {
    	   input[numOfTestCases++] = Long.valueOf(line);
       }
	  
       //Processing on input
       InfiniteImprobabilityDriver driver = new InfiniteImprobabilityDriver();
       for(int i=0; i < numOfTestCases ; i++) {
    	   String resultStr = String.valueOf(driver.getSmallestNumberPermutationsOfPrimeFactorsEqualTo(input[i]));
    	   System.out.println(input[i] + InfiniteImprobabilityDriver.SPACE + resultStr.substring(0, resultStr.indexOf(DECIMAL)));   
       }
	   
	}

	private double getSmallestNumberPermutationsOfPrimeFactorsEqualTo(long k) {
		
		//If repeated input test case then return from map
		if(resultMap.containsKey(k)) {
			return resultMap.get(k);
		}
		
		//Optimizing to start with k+3 always 
		for (double i = k + 3;;i++) {

			//If number is a prime number then skip it
			if(isPrime(i)) {
				continue;
			}

			double numOfPrimeFactors = getNumOfPrimeFactors(i);
			if(numOfPrimeFactors == k) {
				//Storing the result in a map for optimizing repeated testcase 
				resultMap.put(k, i);
				return i;
			}
		}
	}

	private double getNumOfPrimeFactors(double i) {

		//Fetch all the prime factors of a number and store in a list
		List<Double> primeFactorList = getAllPrimeFactorsFor(i);

		//Counting the number and its occurences and storing in hashmap
		Map<Double, Double> primeFactorCountMap = new HashMap<Double, Double>();
		
		for(Double factor: primeFactorList) {
			if(primeFactorCountMap.containsKey(factor)) {
				Double value =  primeFactorCountMap.get(factor);
				primeFactorCountMap.put(factor,  Double.valueOf(++value ));
			} else{
				primeFactorCountMap.put(factor, Double.valueOf(1));
			}
		}

		//Formula is numberOfUniquePrimeFactors = factorial of total no. of prime factors which is list size 
		// divided by factorial of each number's count  
		double numberOfUniquePrimeFactors = factorial(primeFactorList.size());
		
		Iterator<Double> iter = primeFactorCountMap.values().iterator();
		    while (iter.hasNext()) {
		    	Double value = (Double)iter.next();
		    	numberOfUniquePrimeFactors = numberOfUniquePrimeFactors / (factorial(value)); 
		    }
	    return numberOfUniquePrimeFactors;
	}

	private double factorial(double a){
		
		if(a==1) {
			return 1;
		}
		
		return a * factorial(a-1);
	}
	
	private List<Double> getAllPrimeFactorsFor(double n)
	{
		List<Double> primeFacorList = new ArrayList<Double>();

		while (n%2 == 0) {
	        primeFacorList.add(Double.valueOf(2));
	        n = n/2;
	    }
	 
	    // n must be odd at this point.  So we can skip one element (Note i = i +2)
	    for (double i = 3; i <= Math.sqrt(n); i = i+2) {
	        // While i divides n, print i and divide n
	        while (n%i == 0) {
	        	primeFacorList.add(i);
	            n = n/i;
	        }
	    }
	 
	    // when n is a prime number greater than 2
	    if (n > 2) {
	    	primeFacorList.add(n);
	    }
	    
	    return primeFacorList;
	}
	
	private boolean isPrime(double i) {

		for(double j=2;j<=Math.sqrt(i);j++) {
				 if(i%j ==0) {
					 return false;
				 }
			 }
		return true;
	}
}
