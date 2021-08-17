package com.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
public class SubSet {
	public static List<List<Integer>> subSet(int nums[]){
		Arrays.parallelSort(nums);
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		backTracking(list,new ArrayList<>(),nums, 0);
		return list;
	}
	public static void backTracking(List<List<Integer>> list, List<Integer> tmpList, int nums[], int start) {
		list.add(new ArrayList<>(tmpList));
		for(int i=start;i<nums.length;i++) {
			tmpList.add(nums[i]);
			backTracking(list, tmpList, nums, i+1);
			tmpList.remove(tmpList.size()-1);
		}
	}
	
	// Approach - 2
	public static List<List<Integer>> subsets(int[] nums) {
	    Arrays.sort(nums); // make sure subsets are ordered
	    List<List<Integer>> result = new ArrayList<>();
	    result.add(new ArrayList<>()); // start with empty set
	    for (int i = 0; i < nums.length; ++i) {
	        for (int j = 0, size = result.size(); j < size; j++) { // remember
	            List<Integer> subset = new ArrayList<>(result.get(j)); // copy a new one
	            subset.add(nums[i]); // expand
	            result.add(subset); // collect
	        }
	    }
	    return result;
	}
	public static void main(String[] args) {
		int nums[]= {1,2,3};
		List<List<Integer>> list=subsets(nums);
		for(List<Integer> i:list)
			System.out.println(i);
	}

}
