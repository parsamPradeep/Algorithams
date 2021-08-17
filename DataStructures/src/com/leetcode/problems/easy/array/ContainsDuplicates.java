package com.leetcode.problems.easy.array;
/*
 Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
	
	//Approach - 1
	 public static boolean containsDuplicate1(int[] nums) {
	        Arrays.sort(nums);
	        for(int i=0;i<nums.length-1;i++){
	            if(nums[i]==nums[i+1])return true;
	        }
	        
	        return false;
	    }
	 
	 // Approach - 2
	 public static boolean containsDuplicate2(int[] nums) {
	        Set<Integer> set=new HashSet<Integer>();
			for(int i=0;i<nums.length;i++) {
				if(!set.contains(nums[i]))
	                set.add(nums[i]);
	            else
	                return true;
					
			}
			
	         
	            return false;
	    }
	public static void main(String[] args) {
		int arr[]= {1,1,1,3,3,4,3,2,4,2};
		System.out.println(containsDuplicate1(arr));

	}

}
