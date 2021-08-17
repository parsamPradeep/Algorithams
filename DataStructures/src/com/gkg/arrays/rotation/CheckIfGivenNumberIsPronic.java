package com.gkg.arrays.rotation;
/*
 Pronic number is a number which is the product of two consecutive integers, 
 that is, a number n is a product of x and (x+1). 
 
Input :56
Output :Pronic Number
Explanation: 56 = 7 * 8 i.e 56 is a product 
of two consecutive integers 7 and 8. 

Input  : 8
Output : Not a Pronic Number
Explanation: 8 = 2 * 4 i.e 8 is a product of 
2 and 4 which are not consecutive integers.
 */
public class CheckIfGivenNumberIsPronic {
	
	public static boolean checkPronic(int num) {
		for(int i=0;i<Math.sqrt(num);i++) {
			if(i*(i+1)==num)
				return true;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		System.out.println(checkPronic(2));
		System.out.println(checkPronic(56));
		System.out.println(checkPronic(8));

	}

}
