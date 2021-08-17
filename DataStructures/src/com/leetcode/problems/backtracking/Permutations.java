package com.leetcode.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permutation(int nums[]){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		List<Integer> tmpList=null;
		for(int i=0;i<nums.length;i++) {
			tmpList=new ArrayList<>();
			tmpList.add(nums[i]);
			for(int j=0;j<nums.length;j++) {
				if(!tmpList.contains(nums[j]))
					tmpList.add(nums[j]);
			}
			if(nums.length==tmpList.size())
				list.add(new ArrayList<>(tmpList));
		}
		return list;
	}
	public static void main(String[] args) {
		int nums[]= {1,2,3};
		List<List<Integer>>list=permutation(nums);
		for(List<Integer> l:list)
			System.out.println(l);
	}

}
