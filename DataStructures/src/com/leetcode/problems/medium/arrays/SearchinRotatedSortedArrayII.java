package com.leetcode.problems.medium.arrays;
/*
 Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 */
public class SearchinRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {
        if(nums.length==1)
            return nums[0]==target;
        int j=nums.length-1;
        for(int i=0;i<=nums.length/2;i++){
            if(nums[i]==target || nums[j]==target)
                return true;
            j--;
        }
        return false;
    }
	public static void main(String[] args) {
		int nums[]= {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(search(nums, target));
	}
}
