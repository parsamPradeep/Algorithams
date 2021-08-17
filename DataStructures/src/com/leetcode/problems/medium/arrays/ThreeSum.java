package com.leetcode.problems.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 */
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						list.add(Arrays.asList(nums[lo], nums[hi], nums[i]));
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (nums[hi] + nums[lo] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int nums[]= {-1,0,1,2,-1,-4,-2,-3,3,0,4};
		System.out.println(threeSum(nums));
	}

}
