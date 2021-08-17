package com.leetcode.problems.medium.arrays;
/*
 Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> subSet(int nums[]){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		backTrack(list, new ArrayList<>(), nums, 0);
		return list;
	}
	public static void backTrack(List<List<Integer>> list, List<Integer> tempList, int nums[], int start) {
	list.add(new ArrayList<>(tempList));
	for(int i=start;i<nums.length;i++) {
		tempList.add(nums[i]);
		backTrack(list, tempList, nums, i+1);
		tempList.remove(tempList.size()-1);
	}
	}
	public static void main(String[] args) {
		int nums[]= {1,2,3};
		List<List<Integer>> list=subSet(nums);
		for(List<Integer> i: list)
			System.out.println(i);

	}

}
