package com.leetcode.problems.easy.array;
/*
You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n).
Return the highest altitude of a point.

 

Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 */
public class FindTheHighestAltitude {
//Approach -1 
	 public static int largestAltitude1(int[] gain) {
		 int cur_altitute=0;
		 int res=0;
		 for(int i=0;i<gain.length;i++) {
			 cur_altitute+=gain[i];
			 res=Math.max(cur_altitute, res);
		 }
		 return res;
	 }
	 
// Approach - 2
	 public static int largestAltitude2(int[] gain) {
	        if(gain.length==1)
	            return gain[0]>0?gain[0]:0;
	       int res=0;
	        for(int i=0;i<gain.length-1;i++){
	            if(gain[i]>res)
	                res=gain[i];
	             gain[i+1]=gain[i]+gain[i+1];
	            if( (gain[i+1]>=1) && (gain[i+1]>res) ){
	                    res=gain[i+1];
	            }

	        }

	        return res;
	    }
	public static void main(String[] args) {
		int gain[]= {52,-91,72};
		System.out.println(largestAltitude1(gain));
	}

}
