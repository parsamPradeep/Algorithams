package com.leetcode.problems.medium.arrays;
/*
Example 1:

Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
Example 2:

Input: boxes = "001011"
Output: [11,8,5,4,3,4]
 */
public class MinNumberofOperationstoMoveAllBallstoEachBox {
	
	// Approach -1 
	 public static int[] minOperations1(String boxes) {
	        int length = boxes.length();
	        int [] result = new int [length];
	        int count = 0;
	        int output = 0;
	        for (int i=0; i<length; i++) {
	            result[i] += output;
	            count += boxes.charAt(i) == '1' ? 1 : 0;
	            output += count;
	        }
	        output = 0;
	        count = 0;
	        for (int i=length - 1; i>=0; i--) {
	            result[i] += output;
	            count += boxes.charAt(i) == '1' ? 1 : 0;
	            output += count;
	        }
	        return result;
	    }
	 
	 // Approach -2
	 public static int[] minOperations2(String boxes) {
	        int res[]=new int[boxes.length()];
	        for(int i=0;i<res.length;i++){
	            for(int j=0;j<res.length;j++){
	                if(boxes.charAt(j)=='1')
	                    res[i]+=Math.abs(j-i);
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		String boxes="001011";
		int res[]=minOperations1(boxes);

	}

}
