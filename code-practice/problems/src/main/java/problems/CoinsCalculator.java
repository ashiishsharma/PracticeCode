package problems;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CoinsCalculator {

	private static final String COINS_OF_1_4_ASIAP_EACH = " coins of 1/4 asiap each";
	private static final String COINS_OF_1_2_ASIAP_EACH = " coins of 1/2 asiap each";
	private static final String COINS_OF_4_ASIAP_EACH = " coins of 4 asiap each";
	private static final String SEPERATOR = "===";
	private static final String NO_SOLUTION_FOUND = "No Solution found";
	private static final String CASE = "Case ";
	private static final String COLON = ":";
	private static final String NEW_LINE = "\n";
	private static final String DECIMAL = ".";
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		

		CoinsCalculator calculator = new CoinsCalculator();
		ArrayList<Double> inputList = new ArrayList<Double>();
		
		//Reading input and storing in list 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
	    while( ( ( line=reader.readLine()) != null) && !(line.trim().length() == 0) ) {
	    	inputList.add(Double.parseDouble(line));
	    }
	       
	    //Processing the input
	    StringBuilder output = new StringBuilder();
	    for(Double input:  inputList) {
	    	output.append(CASE);
	    	String inputStr = String.valueOf(input);
	    	output.append(inputStr.substring(0, inputStr.indexOf(DECIMAL)));
	    	output.append(COLON);
	    	output.append(NEW_LINE);

			try {
				String[] combination = calculator.getCoinCombination(input);
				output.append(combination[0].substring(0, combination[0].indexOf(DECIMAL)));
	    		output.append(COINS_OF_4_ASIAP_EACH);
	    		output.append(NEW_LINE);
	    		output.append(combination[1].substring(0, combination[1].indexOf(DECIMAL)));
		    	output.append(COINS_OF_1_2_ASIAP_EACH);
	    		output.append(NEW_LINE);
	    		output.append(combination[2].substring(0, combination[2].indexOf(DECIMAL)));
		    	output.append(COINS_OF_1_4_ASIAP_EACH);
			} catch (NoCombinationFoundException e) {
				output.append(NO_SOLUTION_FOUND);
			}
			   output.append(NEW_LINE);
       	       output.append(SEPERATOR);
	    	   output.append(NEW_LINE);
	       }
	       
	       //Writing the output to console
	       System.out.println(output.toString());
	}

	private String[] getCoinCombination(double sum) throws NoCombinationFoundException {
		
		//Multiplying the i/p denomination by 4 to work in whole numbers
		sum = sum * 4;
		//Multiplying coins values by 4 to work in whole numbers
		double coin1Val = 16;
		double coin2Val = 2;
		double coin3Val = 1;
	    
	    for (double i = Math.floor(sum/coin1Val);  i * coin1Val <= sum && i > 0; i--) {
	    	double tempJ = Math.floor( (sum- (i*coin1Val))/coin2Val);
	    	for (double j = tempJ; i * coin1Val + j * coin2Val <= sum && j>0 ; j--) {
	    		for (double k = (sum - Math.floor((i*coin1Val + j*coin2Val)/coin3Val)); i * coin1Val + j * coin2Val + k * coin3Val <= sum && k>0 ; k--) {
	    			if ( (i * coin1Val + j * coin2Val + k * coin3Val == sum) && ((i+j+k)*4 == sum)) {
	    				//Returning i coins of 4, j coins of .5 and k coins of .25 denomination
	    				return new String[]{String.valueOf(i), String.valueOf(j),String.valueOf(k)};
	    			}
	    		}
	    	}
	    }
	    throw new NoCombinationFoundException();
	}
	
	private class NoCombinationFoundException extends Exception {

		private static final long serialVersionUID = 1L;

		public NoCombinationFoundException() {
			super();
		}


	}
}
