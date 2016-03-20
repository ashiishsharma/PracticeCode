package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
 
 /**
  * 5 10 5
1 2 1 2
1 5 3 4
2 4 4 5
2 5 5 6
4 5 6 7
  * 
  *
  */
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File("TravellingPlan.in")));

		String[] input = reader.readLine().split(" ");

		int nr_stations = Integer.parseInt(input[0]);
		int maxTravelTime = Integer.parseInt(input[1]);
		int nr_bus = Integer.parseInt(input[2]);
 
		TravellingBus tabus = new TravellingBus(nr_stations, maxTravelTime);
		for (int i = 0; i < nr_bus; i++) {
			input = reader.readLine().split(" ");
			tabus.addBus(Integer.parseInt(input[0]) -1 , Integer.parseInt(input[1]) -1, Integer.parseInt(input[2]), Integer.parseInt(input[3]));
		}
		tabus.solve();
	}
}
 
class TravellingBus {
 
	List<Bus2> busList = new ArrayList<Bus2>();
	List<List<Integer>> endtimeList = new ArrayList<List<Integer>>();
	int nr_stations;
	int maxTravelTime;
 
	public TravellingBus(int nr_stations, int maxTravelTime) {
		this.nr_stations = nr_stations;
		this.maxTravelTime = maxTravelTime;
	}
 
	public void initializeEndtimeList() {
		for (int i = 0; i < nr_stations; i++)
			endtimeList.add(new ArrayList<Integer>());
	}
 
	public void clearEndtimeList() {
		for (List<Integer> list : endtimeList)
			list.clear();
	}
 
	public boolean isPossible(int maxWaitingTime) { // Is it possible to reach destination  within this time // 5 then // 2 // then 1 
		endtimeList.get(0).add(0); // station wise list 0,endTime 1,endTime 2,endTime 3,endTime 4,endTime initialized to 0
		for (Bus2 bus : busList) {
			int startStation = bus.startStation;
			if (isWithinRange(endtimeList.get(startStation), bus.startTime,	maxWaitingTime)) { // 0,1,5 
				endtimeList.get(bus.endStation).add(bus.endTime); // 0 1 2 3 4
																  //   2
			}
		}
		List<Integer> lastStationEndtimes = endtimeList.get(nr_stations - 1); //Dest station end times
		boolean result = false;
		if (!lastStationEndtimes.isEmpty())
			result = lastStationEndtimes.get(0) <= maxTravelTime; // Dest end time is less than max time 
		clearEndtimeList();
		return result;
	}
 
	public boolean isWithinRange(List<Integer> endtimeList, int startTime, int maxWaitingTime) {
		int lo = 0;
		int hi = endtimeList.size() - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int endTimeVal = endtimeList.get(mid);
			if (endTimeVal + maxWaitingTime < startTime)
				lo = mid + 1;
			else if (endTimeVal > startTime)
				hi = mid - 1;
			else
				return true;
		}
		return false;
	}
 
	public void solve() {
		//Sort by end time lowest endTime first 
		Collections.sort(busList);
		/**
		 *  0 1 1 2
			0 4 3 4
			1 3 4 5
			1 4 5 6
			3 4 6 7
		 */
		initializeEndtimeList();
		int lo = 0; //0
		int hi = maxTravelTime + 1; // 11
		
		while (lo < hi) {
			int mid = (lo + hi) / 2; //mid=5
			
			if (!isPossible(mid))
				lo = mid + 1;
			else
				hi = mid;
		}
		
		if (hi <= maxTravelTime)
			System.out.println(hi);
		else
			System.out.println("-1");
	}
 
	public void addBus(int startStation, int endStation, int startTime,
			int endTime) {
		Bus2 bus = new Bus2();
		bus.startStation = startStation;
		bus.endStation = endStation;
		bus.startTime = startTime;
		bus.endTime = endTime;
		this.busList.add(bus);
	}
 
}
 
class Bus2 implements Comparable<Bus2> {
	int startStation;
	int endStation;
	int startTime;
	int endTime;
 
	public int compareTo(Bus2 target) {
		return this.endTime - target.endTime;
	}
 
}