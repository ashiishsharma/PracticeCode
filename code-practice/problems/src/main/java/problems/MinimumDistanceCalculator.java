package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceCalculator {

	private static final String SPACE = " ";
	private static final String PRECISION_FORMAT = "#0.00000";
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		MinimumDistanceCalculator calculator = new MinimumDistanceCalculator();
	
		//Reading input and storing 
		   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		   short noOfCoordinates = Short.parseShort(reader.readLine());

		   Path a = calculator.new Path();
		   for(int i=0; i <noOfCoordinates; i++) {
			   String[] coordinates = reader.readLine().split(MinimumDistanceCalculator.SPACE);
			   Coordinate c = calculator.new Coordinate(Short.parseShort(coordinates[0]), Short.parseShort(coordinates[1]));
			   a.getPath().add(c);
		   }
		   a.calculateStepsAndCoordinates();
		   
		   noOfCoordinates = Short.parseShort(reader.readLine());
		   
		   Path b = calculator.new Path();
		   for(int i=0; i <noOfCoordinates; i++) {
			   String[] coordinates = reader.readLine().split(MinimumDistanceCalculator.SPACE);
			   Coordinate c = calculator.new Coordinate(Short.parseShort(coordinates[0]), Short.parseShort(coordinates[1]));
			   b.getPath().add(c);
		   }
		   b.calculateStepsAndCoordinates();
		   
		  
	      //Processing on input
	      try {
			  System.out.println(calculator.calculateMinimumDistance(a, b));
	      } catch (NoPathFound e) {
			  System.out.println("impossible");
	      }
	
		
	}

	
	private String calculateMinimumDistance(Path a, Path b) throws NoPathFound{
		double minDistance = 0;
		if(arePathsParallel(a,b)){
			minDistance = getDistanceBetweenLines(a,b) ;
			if( a.getNumOfSteps() < ((short)minDistance)   || b.getNumOfSteps()  < ((short) minDistance) ) {
				throw new NoPathFound();
			}
		}else{
			minDistance = getMinDistanceBetweenPaths(a,b);
			
		}
		
		return new DecimalFormat(PRECISION_FORMAT).format(minDistance);
	}

	private double getMinDistanceBetweenPaths(Path a, Path b) throws NoPathFound {

		List<Coordinate> aListOfCordinates = a.getListOfCoordinates();
		List<Coordinate> bListOfCordinates = b.getListOfCoordinates();
		
		for(Coordinate aCoordinate : aListOfCordinates) {
			
			Coordinate mCoordinate = new Coordinate(aCoordinate.getX(), aCoordinate.getY()); 
			double minCost=0;
			for(int i=1; i < bListOfCordinates.size(); i++) {
				Coordinate bCoordinate = bListOfCordinates.get(i);
				Coordinate optimizedMoveCoordinate = getMostOptimizedMove(mCoordinate, bCoordinate);
				minCost = minCost + optimizedMoveCoordinate.getCost();
				if(optimizedMoveCoordinate.equals(bCoordinate)) {
					return minCost;
				}
				mCoordinate = optimizedMoveCoordinate;
			}
		}
		throw new NoPathFound();
	}


	private Coordinate getMostOptimizedMove(Coordinate mCoordinate, Coordinate bCoordinate) {
		
		List<Coordinate> list = new ArrayList<Coordinate>();
		short x = mCoordinate.getX();
		short y = mCoordinate.getY();

		evaluateCoordinate((short) (x+1),y,bCoordinate, list, 1);
		evaluateCoordinate(x,(short) (y+1),bCoordinate, list, 1);
		evaluateCoordinate((short) ((short) x+1),(short) (y+1),bCoordinate, list, Math.sqrt(2));
		evaluateCoordinate((short) ((short) x+1),(short) (y-1),bCoordinate, list, Math.sqrt(2));
		evaluateCoordinate((short) (x-1),y,bCoordinate, list,1);
		evaluateCoordinate((short) (x),(short) (y-1),bCoordinate, list,1);
		evaluateCoordinate((short) ((short) x-1),(short) (y-1),bCoordinate, list, Math.sqrt(2));
		evaluateCoordinate((short) ((short) x-1),(short) (y+1),bCoordinate, list, Math.sqrt(2));
		
		return coordinateWithLeastDistance(list);
	}


	private Coordinate coordinateWithLeastDistance(List<Coordinate> list) {

		double minCost = Double.MAX_VALUE;
		Coordinate minc = null;
		for(Coordinate c: list) {
			if(c.getDistance() < minCost) {
				minCost = c.getDistance();
				minc = c;
			}
		}
		return minc;
	}


	private void evaluateCoordinate(short i, short j, Coordinate bCoordinate,List<Coordinate> list, double cost) {

		if(i> 30000 || j > 30000 || i<0 || j<0) {
			return;
		}
	
		Coordinate move = new Coordinate(i, j);
		double distance = bCoordinate.getDistance(move);
		move.setDistance(distance);
		move.setCost(cost);
		list.add(move);
	}


	private double getDistanceBetweenLines(Path x, Path y) {

		short x1 = x.getPath().get(0).getX();
		short y1 = x.getPath().get(0).getY();
		short x2 = y.getPath().get(0).getX();
		short y2 = y.getPath().get(0).getY();
		
		if(x.isLineHorizontal && y.isLineHorizontal) {
			return (short)Math.abs(y2-y1);
		} else if(x.isLineVertical && y.isLineVertical) {
			return (short)Math.abs(x2-x1);
		}
		return 0;
	}


	private boolean arePathsParallel(Path x, Path y) {

		if(x.isPathStraightLine() && y.isPathStraightLine()) {
			if(x.slopeOfLine() == y.slopeOfLine()) {
				return true;
			}
		}
		return false;
	}

	private class Coordinate {
		
		private short x;
		private short y;
		private double distance;
		private double cost;
		
		public double getCost() {
			return cost;
		}


		public void setCost(double cost) {
			this.cost = cost;
		}


		public double getDistance() {
			return distance;
		}


		public void setDistance(double cost) {
			this.distance = cost;
		}


		public Coordinate(short x, short y) {
			super();
			this.x = x;
			this.y = y;
		}


		public short getX() {
			return x;
		}


		public void setX(short x) {
			this.x = x;
		}


		public short getY() {
			return y;
		}


		public void setY(short y) {
			this.y = y;
		}

		public double getDistance(Coordinate b) {
			return Math.sqrt(Math.pow(Math.abs(b.getX() - x),2) +Math.pow(Math.abs(b.getY() - y),2)); 
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinate other = (Coordinate) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}


		private MinimumDistanceCalculator getOuterType() {
			return MinimumDistanceCalculator.this;
		}
		
		
		
		
	}
	
	private class Path {
		
		public Path() {
		}
		private boolean isLineHorizontal =false;
		private boolean isLineVertical =false;
		private int numOfSteps = 0;
		
		private ArrayList<Coordinate> path = new ArrayList<Coordinate>();
		private ArrayList<Coordinate> listOfCoordinates = new ArrayList<Coordinate>();
		
		public ArrayList<Coordinate> getPath() {
			return path;
		}
		
		public ArrayList<Coordinate> getListOfCoordinates() {
			return listOfCoordinates;
		}
		
		private void calculateStepsAndCoordinates() {

			short x1 = path.get(0).getX();
			short y1 = path.get(0).getY();
			listOfCoordinates.add(path.get(0));
		
			for (int i=1; i < path.size() ; i++) {
				Coordinate c = path.get(i);
				short x2 = c.getX();
				short y2 = c.getY();
				numOfSteps =  numOfSteps + Math.abs(x2-x1) + Math.abs(y2-y1);
		
				if(x1==x2) {
					int totY = Math.abs(y2-y1);
					for(int j =0; j <totY ; j++ ) {
						if(y1 < y2) {
							listOfCoordinates.add(new Coordinate(x1, ++y1)); 
						}else{
							listOfCoordinates.add(new Coordinate(x1, --y1));
						}
					}
				}
				
				if(y1==y2) {
					int totX = Math.abs(x2-x1);
					for(int j =0; j < totX; j++ ) {
						if(x1<x2) {
							listOfCoordinates.add(new Coordinate(++x1, y1));
						}else {
							listOfCoordinates.add(new Coordinate(--x2, y1));
						}
					}
				}
				x1=x2;
				y1=y2;
			}			
			
			
		}
		
		
		public int getNumOfSteps() {
			return numOfSteps;
		}
		public boolean isPathStraightLine() {
			boolean isPathStraight = true;
			short x1 = path.get(0).getX();
			short y1 = path.get(0).getY();
			boolean xChanged = false;
			boolean yChanged = false;
			for (int i=1; i < path.size() ; i++) {
				Coordinate c = path.get(i);
				short x2 = c.getX();
				short y2 = c.getY();
				
				if(x2 != x1) {
					xChanged = true;
				}
				
				if(y2!=y1) {
					yChanged = true;
				}
			}
	
			if(xChanged && yChanged ) {
				isPathStraight = false;
			}
			
			if(!xChanged) {
				isLineVertical = true;
			}
			if(!yChanged) {
				isLineHorizontal = true;
			}
			
			return isPathStraight;
		}
		
		
		
		
		public boolean isLineHorizontal() {
			return isLineHorizontal;
		}

		public void setLineHorizontal(boolean isLineHorizontal) {
			this.isLineHorizontal = isLineHorizontal;
		}

		public boolean isLineVertical() {
			return isLineVertical;
		}

		public void setLineVertical(boolean isLineVertical) {
			this.isLineVertical = isLineVertical;
		}

		public short slopeOfLine() {
			short x1 = path.get(0).getX();
			short y1 = path.get(0).getY();
			short x2 = path.get(1).getX();
			short y2 = path.get(1).getY();
			if(x2-x1 == 0 || y2-y1 ==0) {
				return 0;
			}
			if(x2-x1 !=0 ) {
				return (short) Math.abs((short) (y2 -y1)/(x2-x1));
			}
			return (short)Math.abs((y2 -y1));
		}
		
		
	}
	
	private class NoPathFound extends Exception {

		public NoPathFound() {
			super();
		}


	}
}
