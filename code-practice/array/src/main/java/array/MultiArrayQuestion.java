package array;

import java.util.HashSet;
import java.util.Set;

/**
 * If an element in a MxN array is 0 then set its entire row column 0
 * @author batraa
 *
 */
public class MultiArrayQuestion {

	
	private static void setZero(int arr[][], int m , int n) {
		Set<Integer> rowSet = new HashSet();
		Set<Integer> colSet = new HashSet();
		
		for (int i = 0 ; i < m; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(arr[i][j] == 0 ) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}
		
		for (int i = 0 ; i < m; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(rowSet.contains(i) || colSet.contains(j)) {
					arr[i][j] = 0;
				}
			}
		}
	}
	
	private static void print(int arr[][], int m , int n) {
		for (int i = 0 ; i < m; i++) {
			for(int j = 0 ; j < n ; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}
	
	public static void main(String[] args) {
		
		//I/P
		//0 1
		//1 2
		//2 3
		
		int arr[][] = new int [][] {{0,1},{1,2},{2,3}}; 
		
		//O/P
		//0 0 
		//0 2
		//0 3
		setZero(arr, 3,2);
		print(arr, 3,2);
		
		//I/P
		//1 2 
		//4 0 
		//6 7 
		
		int arr1[][] = new int [][] {{1,2},{4,0},{6,7}};  
		
		//O/P
		//1 0 
		//0 0 
		//6 0 
		setZero(arr1, 3,2);
		print(arr1, 3,2);
		
		
	}
}
