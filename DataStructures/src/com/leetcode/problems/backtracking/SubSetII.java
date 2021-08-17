package com.leetcode.problems.backtracking;
/*
 Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
	public static List<List<Integer>> subSet(int nums[]) {
		Arrays.parallelSort(nums);
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		backTracking(list, new ArrayList<>(), nums, 0);
		return list;
	}
	public static void backTracking(List<List<Integer>> list , List<Integer> tmpList, int nums[], int start) {
		list.add(new ArrayList<>(tmpList));
		for(int i=start;i<nums.length;i++) {
			if(i>start && nums[i]==nums[i-1])
				continue;
			tmpList.add(nums[i]);
			backTracking(list, tmpList, nums, i+1);
			tmpList.remove(tmpList.size()-1);
		}
	}
	public static void main(String[] args) {
		int nums[]= {1,2,2};
		List<List<Integer>>list=subSet(nums);
		for(List<Integer> l:list)
			System.out.println(l);
	}

}
