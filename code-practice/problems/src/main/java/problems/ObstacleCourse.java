package problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * http://www.codechef.com/problems/COURSE
 * A number of traffic cones have been placed on a circular racetrack to form
an obstacle course. You are asked to determine the largest sized car that can
navigate the course. For simplicity, the cones are assumed to have zero width
and the car is perfectly circular and infinitely maneuverable. The track itself
is the area between 2 concentric circles.
Formally, the course can be navigated by a car of radius c if there exists a
closed loop around the center of the track which lies between the circles forming the track, and
every point on the loop is at least c distance away from each cone and each
boundary of the track.
Input:

Input begins with an integer T (about 25), the number of test cases.
Each test case begins with 2 integers r and R (1<=r<R<=25000). The racetrack is
the area between the circles centered at (0,0) with radii r and R.
The next line of input contains an integer N (0<=N<=500), the number of cones.
N lines follow, each containing the coordinates of a cone. The coordinates are
integers, and are guaranteed to lie within the track, and be distinct.
Cases are separated by a blank line.
Output:

For each input, output on a single line the diameter of the largest car that
can navigate the course, rounded to 3 decimal places.
Sample input:

1

5 10
3
6 0
5 7
-2 -7
Sample output:

2.720
 *
 */
public class ObstacleCourse {

	private static int r;
	private static int R;
	private static ArrayList<Point> pointList = new ArrayList<Point>();
	
	public ObstacleCourse(int parseInt, int parseInt2) {
		r = parseInt;
		R = parseInt2;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"ObstacleCourse.in")));
		int numOfTestCases = Integer.parseInt(reader.readLine());
		FileWriter fw = new FileWriter(new File("ObstacleCourse.out"));
		for (int i = 1; i <= numOfTestCases; i++) {
			// Reading second line
			String[] input = reader.readLine().split(" ");
			ObstacleCourse solver = new ObstacleCourse(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			int numOfPoints = Integer.parseInt(reader.readLine());
			
			for (int j = 1; j <= numOfPoints; j++) {
				String[] point = reader.readLine().split(" ");
				Point p = new Point(Integer.parseInt(point[0]), Integer.parseInt(point[1]));
				pointList.add(p);
			}
			fw.append(getSolution() + "\n");
			System.out.println(getSolution() + "\n");
		}

		fw.flush();
		reader.close();
		fw.close();
	}

	private static double getSolution() {
		
		int maxDistance = R - r;
		
		for(Point p: pointList) {
		
			double distanceFromCenter =  Math.sqrt( (p.getX() * p.getX()) + (p.getY() * p.getY()));
			double distanceFromCloserEnd = distanceFromCenter - r;
			double distanceFromFartherEnd = R - distanceFromCenter ;
			
			if(distanceFromCloserEnd > distanceFromFartherEnd) {
				p.setMaxAllowedByPass(distanceFromCloserEnd);
			}else {
				p.setMaxAllowedByPass(distanceFromFartherEnd);
			}
		}
		
		double min = 999999.0;
		for(Point p: pointList) {
			if(p.getMaxAllowedByPass() < min) {
				min = p.getMaxAllowedByPass();
			}
		}
		
		return min;
	}
}
