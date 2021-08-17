package com.leetcode.problems.easy.array;
/*
Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2
Input: digits = [1,9]
Output: [2,0]

Example 3
Input: digits = [9,9]
Output: [1,0,0]
 */
public class PluseOne {
	 public static int[] plusOne(int[] digits) {
	       


         for(int i=digits.length-1;i>=0;i--){
             
             if(digits[i]<9){
                ++digits[i];
                 return digits;
             }
             digits[i]=0;

     }
      
      int num[]=new int[digits.length+1];
      num[0]=1;
      return num;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
