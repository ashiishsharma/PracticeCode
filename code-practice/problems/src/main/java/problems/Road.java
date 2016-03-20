package problems;

public class Road implements Comparable<Road>{

	
	private int src;
	private int dest;
	private int cost;
	
	
	public Road(int src, int dest, int cost) {
		super();
		this.src = src;
		this.dest = dest;
		this.cost = cost;
	}
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Road o) {
		return this.cost - o.cost;
	}
	
	
	
}
