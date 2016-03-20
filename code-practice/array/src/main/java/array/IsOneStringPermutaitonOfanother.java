package array;

import java.util.Arrays;


public class IsOneStringPermutaitonOfanother {

	
	static boolean isOneStringPermutaitonOfanother(String str1, String str2) {
	
		if(str1.length() != str2.length()) {
			return false;
		}
		
		char str1Arr[] =  str1.toCharArray();
		Arrays.sort(str1Arr);
		
		char str2Arr[] =  str2.toCharArray();
		Arrays.sort(str2Arr);
		
		int i = 0;
		for (char ch : str1Arr) {
			if(ch != str2Arr[i++]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
	
		System.out.println(isOneStringPermutaitonOfanother("str1", "1str"));
		System.out.println(isOneStringPermutaitonOfanother("str", "123"));
		System.out.println(isOneStringPermutaitonOfanother("str", "zz"));
		System.out.println(isOneStringPermutaitonOfanother("213", "123"));
	}
}
