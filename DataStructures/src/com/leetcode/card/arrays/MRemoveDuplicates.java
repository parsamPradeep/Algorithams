package com.leetcode.card.arrays;
/*
Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2,
with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the returned length.

Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, 
with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. 
It doesn't matter what values are set beyond the returned length.
 */
public class MRemoveDuplicates {
	 public static int removeDuplicates(int[] nums) {
	        int i=0;
	        for(int j=1;j<nums.length;j++){
	            if(nums[i]!=nums[j])
	                i++;
	            nums[i]=nums[j];
	        }
	        return i+1;
	    }
	public static void main(String[] args) {
		int arr[]= {0,0,1,1,1,2,2,3,3,4};
		int res = removeDuplicates(arr);
		for(int i=0;i<res;i++)
			System.out.println(arr[i]);

	}

}
