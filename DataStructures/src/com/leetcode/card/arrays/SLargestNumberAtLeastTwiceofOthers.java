package com.leetcode.card.arrays;

/*
Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 

Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 

Note:

nums will have a length in the range [1, 50].
Every nums[i] will be an integer in the range [0, 99].
 */
public class SLargestNumberAtLeastTwiceofOthers {
	
	public static int dominantIndex(int[] nums) {
        int fmax=0,smax=0,index=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>fmax){
                smax=fmax;
                fmax=nums[i];
                index=i;
                
            }else if(nums[i]>smax){
                smax=nums[i];
            }
        }
        if(fmax>=smax*2)
            return index;
        else
            return -1;
    }
	public static void main(String[] args) {
		int arr[]= {3, 6, 1, 0};
		int res=dominantIndex(arr);
		System.out.println(res);
	}

}
