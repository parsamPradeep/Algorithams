package com.leetcode.problems.easy.array;

import java.util.HashSet;
import java.util.Set;

/*
Example 1:

Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.
Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.
Example 3:

Input: nums = [1,2,3,4,5]
Output: 15
Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100 	
 */
public class SumOfUniqueElements {
	 public static int sumOfUnique(int[] nums) {
	        Set<Integer> set=new HashSet<Integer>();
	        Set<Integer> set1=new HashSet<Integer>();
	        int sum=0;
	        for(int i=0;i<nums.length;i++){
	            if(!set.contains(nums[i])){
	                set.add(nums[i]);
	                sum+=nums[i];
	            }else{
	                if(!set1.contains(nums[i])){
	                    set1.add(nums[i]);
	                    sum-=nums[i];
	                }
	            } 
	        }
	        return sum;
	    }
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		System.out.println(sumOfUnique(arr));

	}

}
