package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindAllPossibleDigitsWhichTotalSum {

	/**
	 *
	 * Done iteratively 
	 * findAllPossiblePositiveDigitsWhichTotalSum(1) 
	 * 1 0
	 * 
	 * findAllPossiblePositiveDigitsWhichTotalSum(2) 
	 * 2 0
	 * 1 1 
	 * 
	 * findAllPossiblePositiveDigitsWhichTotalSum(3)
	 * 3 0 
	 * 2 1 
	 * 1 1 1 
	 * 
	 */
	public static void main(String[] args) {
		FindAllPossibleDigitsWhichTotalSum obj = new FindAllPossibleDigitsWhichTotalSum();
//		print(obj.findAllPossiblePositiveDigitsWhichTotalSum(1));
//		print(obj.findAllPossiblePositiveDigitsWhichTotalSum(2));
		print(obj.findAllPossiblePositiveDigitsWhichTotalSum(4));
	}

	private static void print(
			Set<ArrayList<Integer>> findAllPossiblePositiveDigitsWhichTotalSum) {

		Iterator iter = findAllPossiblePositiveDigitsWhichTotalSum.iterator();
		while(iter.hasNext()) {
			ArrayList<Integer> lst = (ArrayList<Integer>) iter.next();
			for(Integer i: lst) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private Set<ArrayList<Integer>> findAllPossiblePositiveDigitsWhichTotalSum(int sum) {
		
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		
		
		ArrayList<Integer> lst = new ArrayList<Integer>();
		for(int i = 1 ; i <= sum ; i ++) {
			lst.add(i);
			System.out.println(i);
		}
		
		//lst contains all no.s
		System.out.println("Combinations");
		
		for(Integer j: lst) {
			if(j < sum) { // 1 2 3
				
				int partialSum = j;
				int count =0;
				
				//Adding same no. till it reaches the total count 1111, 2 2 case
				while(partialSum < sum) {
					partialSum = partialSum + j;
					count ++;
					if(partialSum ==sum){
						ArrayList<Integer> lst1 = new ArrayList<Integer>();
						for(int k = 0 ; k <= count; k++) {
							lst1.add(j);
						}
						Collections.sort(lst1);
						set.add(lst1);
					}
				}

				//resetting partSum = j
				int partSum = j;
				for(int k: lst) {
					partSum = partSum + k;
					if(partSum == sum) {
						ArrayList<Integer> lst1 = new ArrayList<Integer>();
						lst1.add(j);
						lst1.add(k);
						Collections.sort(lst1);
						set.add(lst1);
					}else {
						partSum = partSum - k;
					}
				}
				
			}else if(j==sum) {
				ArrayList<Integer> lst1 = new ArrayList<Integer>();
				lst1.add(sum);
				Collections.sort(lst1);
				set.add(lst1);
			}
		}
		
		return set;
	}

	private ArrayList<Integer> findAllPossiblePositiveDigitsWhichTotalSum(int sum,int i ,ArrayList<Integer> lst ) {
		
		if(i == 1) {
			lst.add(1);
			return lst;
		}
		lst.add(i);
		return findAllPossiblePositiveDigitsWhichTotalSum(sum, i-1,lst);
	}
	
	
	
}
