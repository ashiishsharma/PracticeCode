package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;


/**
 * 
 * http://www.codechef.com/problems/RHOUSE
 *
 */
public class RHouse {

	private  int  numOfBuildings;
	private  int numOfRoads;
	private int numHouses;
	private ArrayList<Road> lst = new ArrayList<Road>();

	
	public ArrayList<Road> getLst() {
		return lst;
	}



	public void setLst(ArrayList<Road> lst) {
		this.lst = lst;
	}



	public int getNumHouses() {
		return numHouses;
	}



	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}



	public int getNumOfBuildings() {
		return numOfBuildings;
	}



	public void setNumOfBuildings(int numOfBuildings) {
		this.numOfBuildings = numOfBuildings;
	}



	public int getNumOfRoads() {
		return numOfRoads;
	}



	public void setNumOfRoads(int numOfRoads) {
		this.numOfRoads = numOfRoads;
	}


	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"RHouse.in")));
		int numOfTestCases = Integer.parseInt(reader.readLine());
		FileWriter fw = new FileWriter(new File("RHouse.out"));
		for (int i = 1; i <= numOfTestCases; i++) {
			// Reading second line
			String[] input = reader.readLine().split(" ");
			RHouse rHouse = new RHouse();
			rHouse.setNumOfBuildings(Integer.parseInt(input[0]));
			rHouse.setNumOfRoads(Integer.parseInt(input[1]));
			String numOfHouses = reader.readLine();
			int count= 0;
			for( int j = 0 ; j < numOfHouses.length() ; j ++ ) {
				if((numOfHouses.charAt(j)) == 'H') {
					count++;
				}
			}
			rHouse.setNumHouses(count);
			
			for ( int k = 0 ; k < rHouse.getNumOfRoads() ; k ++ ) {
				input = reader.readLine().split(" ");	
				rHouse.getLst().add(new Road(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
			}
			
			fw.append(rHouse.findMinCost() + "\n");
			System.out.println( rHouse.findMinCost() + "\n");
		}

		fw.flush();
		reader.close();
		fw.close();
	}



	public int findMinCost() {

		if(numHouses == 0) {
			return 0;
		}
		
		Collections.sort(lst);
		int  cost = 0;
		for (int i = 0 ; i < numHouses ; i ++) {
			cost = cost + lst.get(i).getCost(); 
		}
		return cost;
	}
	
}
