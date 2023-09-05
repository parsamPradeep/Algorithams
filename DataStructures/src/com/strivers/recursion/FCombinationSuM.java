package com.strivers.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FCombinationSuM {
	public List<List<Integer>> combinationSum(int arr[], int target) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> currComb=new ArrayList<>();
		helper(0, target, 0, ans, currComb, arr);
		return new ArrayList<>(ans);
	}
	private void helper(int inx, int target, int curSum, List<List<Integer>> ans, List<Integer> currComb, int arr[]) {
		if(inx>=arr.length) return;
		if(curSum==target) {
			ans.add(new ArrayList<>(currComb));
			return;
		}
		if(curSum<target) {
			currComb.add(arr[inx]);
			curSum+=arr[inx];
			helper(inx, target, curSum, ans, currComb, arr);
			curSum-=arr[inx];
			currComb.remove((Integer)arr[inx]);
		}
		helper(inx+1, target, curSum, ans, currComb, arr);
		
	}
	//TC:- O(2powN) *K 
	public static void main(String args[]) {
		int arr1[]= {1,2,3};
		int target1=5;
		int arr2[]= {2,3,5};
		int target2=8;
		FCombinationSuM obj=new FCombinationSuM();
		System.out.println(obj.combinationSum(arr1, target1)); //Ans  [[2, 2, 3], [7]]	
		System.out.println(obj.combinationSum(arr2, target2)); //Ans [[2,2,2,2],[2,3,3],[3,5]]
	}
}
