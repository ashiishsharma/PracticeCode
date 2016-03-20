package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class AnyProblemWith2InputParams {

	private final int x;
	private final int y;
	
	public AnyProblemWith2InputParams(int parseInt, int parseInt2) {
		x = parseInt;
		y = parseInt2;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"AnyProblemWith2InputParams.in")));
		int numOfTestCases = Integer.parseInt(reader.readLine());
		FileWriter fw = new FileWriter(new File("AnyProblemWith2InputParams.out"));
		for (int i = 1; i <= numOfTestCases; i++) {
			// Reading second line
			String[] input = reader.readLine().split(" ");
			AnyProblemWith2InputParams solver = new AnyProblemWith2InputParams(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			fw.append("Case #" + i + ": " + getSolution(solver) + "\n");
			System.out.println("Case #" + i + ": " + getSolution(solver) + "\n");
		}

		fw.flush();
		reader.close();
		fw.close();
	}

	private static String getSolution(AnyProblemWith2InputParams solver) {
		return null;
	}
}
