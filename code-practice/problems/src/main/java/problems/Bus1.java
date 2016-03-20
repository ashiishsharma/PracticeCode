package problems;

public class Bus1 implements Comparable<Bus1>{

	int uStartStation;
	int vDestStation;
	int sStartStationTime;
	int eDestStationTime;
	int travelTime;
	int busNo;
	
	public Bus1(int busNo, int uStartStation, int vDestStation, int sStartStationTime,int eDestStationTime) {
		super();
		this.busNo = busNo;
		this.uStartStation = uStartStation;
		this.vDestStation = vDestStation;
		this.sStartStationTime = sStartStationTime;
		this.eDestStationTime = eDestStationTime;
		travelTime = eDestStationTime - sStartStationTime;
	}
	
	public int compareTo(Bus1 o) {
		return this.eDestStationTime-o.eDestStationTime;
	}
	
	public int getuStartStation() {
		return uStartStation;
	}
	public void setuStartStation(int uStartStation) {
		this.uStartStation = uStartStation;
	}
	public int getvDestStation() {
		return vDestStation;
	}
	public void setvDestStation(int vDestStation) {
		this.vDestStation = vDestStation;
	}
	public int getsStartStationTime() {
		return sStartStationTime;
	}
	public void setsStartStationTime(int sStartStationTime) {
		this.sStartStationTime = sStartStationTime;
	}
	public int geteDestStationTime() {
		return eDestStationTime;
	}
	public void seteDestStationTime(int eDestStationTime) {
		this.eDestStationTime = eDestStationTime;
	}
	
	
}
