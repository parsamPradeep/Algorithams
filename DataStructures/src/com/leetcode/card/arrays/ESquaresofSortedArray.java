package com.leetcode.card.arrays;
/*
Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.


Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */
public class ESquaresofSortedArray {

	
	 public static int[] sortedSquares(int[] nums) {
	        int n=nums.length;
	        int left=0, right=n-1;
	        int arr[]=new int[n];
	        for(int i=n-1;i>=0;i--){
	          if(Math.abs(nums[left])>nums[right]){
	              arr[i]=nums[left]*nums[left];
	              left++;
	          }else{
	               arr[i]=nums[right]*nums[right];
	              right--;
	          }
	        }
	    return arr;
	        
	    }
	public static void main(String[] args) {
		int nums[] = {-4,-1,0,3,10};
		int res []=sortedSquares(nums);
		for(int i:res)
			System.out.println(i);
	}

}
