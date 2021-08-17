package com.leetcode.problems.easy.array;
/*
 Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Example 4:

Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {
	// Approach -1
	 public static int missingNumber1(int[] nums) {
		 int len=nums.length;
		 int sum=len*(len+1)/2;
		 for(int i=0;i<nums.length;i++)
			 sum-=nums[i];
		 return sum;
	 }
	// Approach -2
	 public static int missingNumber2(int[] nums) {
	        int arr[]=new int[nums.length+1];
	        for(int i=0;i<nums.length;i++){
	            arr[nums[i]]=1;
	        }
	        for(int i=0;i<arr.length;i++)
	            if(arr[i]==0)
	                return i;
	        return 1;
	    }
	public static void main(String[] args) {
		int nums[]= {9,6,4,2,3,5,7,0,1};
		System.out.println(missingNumber1(nums));

	}

}
