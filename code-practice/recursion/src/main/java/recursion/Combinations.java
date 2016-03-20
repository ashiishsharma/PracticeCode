package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		findAllCombinationsOfAString("abcd");
		findAllCombinationsOfArray(new int[] {1,2,3,4});
		
	}


	private static void findAllCombinationsOfArray(int[] arr) {

		List<List<Integer>> lst = findAllCombOfArray(arr, 0);
		for(List<Integer> comb: lst) {
			System.out.println(comb.toString());
		}
	}

	private static List<List<Integer>> findAllCombOfArray(int[] arr, int index) {

		if(arr.length == 1) {
			List<List<Integer>> lst=  new ArrayList<List<Integer>>();
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(arr[0]);
			lst.add(temp);
			return lst;
		}
		
		int elem  = arr[index];
			
		int[] newArr = new int[arr.length-1] ;
		for(int  i = 1 ; i < arr.length ; i++) {
			newArr[i-1] = arr[i];
		}
		
		List<List<Integer>> lst= findAllCombOfArray( newArr, 0);
		List<List<Integer>> newlst=  new ArrayList<List<Integer>>();
		for(List<Integer> comb: lst) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(elem);
			temp.addAll(comb);
			newlst.add(temp);
			List<Integer> temp1 = new ArrayList<Integer>();
			temp1.addAll(comb);
			temp1.add(elem);
			newlst.add(temp1);
		}
		return newlst;
	}

	private static void findAllCombinationsOfAString(String str) {

		List<String> lst = findAllCombinationsOfAString1(str);
		for(String x:lst) {
			System.out.println(x);
		}
	}

	private static List<String> findAllCombinationsOfAString1(String str) {

		if(str.length() == 1) {
			List<String> lst  = new ArrayList<String>();
			lst.add(str);
			return lst;
		}
		
		//a
		char ch = str.charAt(0);
		List<String> lst  = findAllCombinationsOfAString1(str.substring(1));
		List<String> newlst  = new ArrayList<String>();
		for(String x: lst) {
			newlst.add(ch+x);
			newlst.add(x+ch);
		}
		return newlst;
	}
	
	
	
	
	
}
