package com.leetcode.problems.medium.arrays;
/*
 Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 */
public class SearchinRotatedSortedArrayI {
	 public static int search(int[] nums, int target) {
	        if(nums.length==1)
	            return nums[0]==target?0:-1;
	        int j=nums.length-1;
	        for(int i=0;i<=nums.length/2;i++){
	            if(nums[i]==target)
	                return i;
	            if(nums[j]==target)
	                return j;
	            j--;
	        }
	        return -1;
	    }
	public static void main(String[] args) {
		int nums[]= {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(search(nums, target));
	}

}
