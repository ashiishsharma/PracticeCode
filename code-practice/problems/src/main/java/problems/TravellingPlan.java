package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * http://www.codechef.com/problems/TABUS
 * 
 *
 */
public class TravellingPlan {

	private static int destStation;
	private static int startStation = 1;
	private static int deadline;
	private static int numOfBuses;
	
	private static Bus1[] busList = new Bus1[5];
	
	public TravellingPlan(int parseInt, int parseInt2, int parseInt3) {
		destStation = parseInt;
		deadline = parseInt2;
		numOfBuses = parseInt3;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"TravellingPlan.in")));
		
		String[] input = reader.readLine().split(" ");
		TravellingPlan solver = new TravellingPlan(Integer.parseInt(input[0]),Integer.parseInt(input[1]), Integer.parseInt(input[2]));
		
		FileWriter fw = new FileWriter(new File("TravellingPlan.out"));
		for (int i = 1; i <= numOfBuses; i++) {
			// Reading second line
			input = reader.readLine().split(" ");
			Bus1 bus = new Bus1( i, Integer.parseInt(input[0]) , Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]) );
			busList[i-1] = bus;
//			fw.append(getSolution(solver) + "\n");
//			System.out.println( getSolution(solver) + "\n");
		}

		int start=0, end=1000000000, mid;
		while(start<end) {
			mid = (start+end)/2;
			if(canReach(busList, mid, destStation)) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		
		if(canReach(busList, start, destStation)) {
			fw.append(start+"");
			System.out.println(start);
		}
		else {
			fw.append("-1");
			System.out.println("-1");
		}
		
		fw.flush();
		reader.close();
		fw.close();
	}
	
	static boolean  canReach(Bus1[] bus, int waitTime, int destStn) {
		ArrayList<Integer> discoveryTime[] = new ArrayList[destStn];
		for(int i=0;i<destStn;i++) {
			discoveryTime[i] = new ArrayList<Integer>();
		}
		
		discoveryTime[0].add(0);
		
		for(int i=0;i<bus.length;i++) {
			if(!discoveryTime[bus[i].uStartStation].isEmpty()) {
				//binary search for element bus[i].S
				int idx = discoveryTime[bus[i].uStartStation].isEmpty() ? 0 : Collections.binarySearch(discoveryTime[bus[i].uStartStation], bus[i].sStartStationTime-waitTime);
				if(idx<0) idx = -(idx+1);
				
				if(!discoveryTime[bus[i].uStartStation].isEmpty()&& idx<discoveryTime[bus[i].uStartStation].size()) {
					Integer reachTime = discoveryTime[bus[i].uStartStation].get(idx);
					if(bus[i].sStartStationTime >= reachTime && bus[i].sStartStationTime - reachTime <= waitTime) {
						 discoveryTime[bus[i].vDestStation].add(bus[i].eDestStationTime);
					}
				}
			}
		}
		
		if(!discoveryTime[destStn-1].isEmpty()) {
			return true;
		}
		
		return false;
	}

	private static int getSolution(TravellingPlan solver) {
		
		ArrayList<Integer> waitTime = new ArrayList<Integer>();
		
		for(Bus1 bus: busList) {
		
			if(bus.getuStartStation() == startStation) {
				if(bus.getvDestStation() == destStation) {
					waitTime.add(bus.getsStartStationTime());
				}

				
				
				
			}
			
		}
		
		return minWaitTime(waitTime);
	}

	private static int minWaitTime(ArrayList<Integer> waitTime) {
		int min=99999999;
		if(waitTime.size() == 0) {
			return -1;
		}
		else
		{
			for(int time: waitTime ) {
				
				if(time < min) {
					min = time;
				}
			}
		}
		return min;
	}
}
