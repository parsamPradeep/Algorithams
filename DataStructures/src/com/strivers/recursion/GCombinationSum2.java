package com.strivers.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GCombinationSum2 {
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	       List<List<Integer>> ans = new ArrayList<>();
			List<Integer> currComb=new ArrayList<>();
	        Arrays.sort(candidates);
			helper(0, target, 0, ans, currComb, candidates);
			return new ArrayList<>(ans);
	    }
	    public void helper(int inx, int target, int currSum, List<List<Integer>> ans, List<Integer> currComb, int candidates[]) {
			if(currSum>target){
	            return;
	        }
	        if(currSum==target){
	            ans.add(new ArrayList<>(currComb));
	            return;
	        }
	        for(int i=inx; i<candidates.length;i++){
	            if(i>inx && candidates[i]==candidates[i-1]) continue;
	            if(candidates[i]+currSum>target) break;
	            currComb.add(candidates[i]);
	            
	            currSum+=candidates[i];
	            helper(i+1, target, currSum, ans, currComb, candidates);
	            currComb.remove((Integer) candidates[i]);
	            currSum-=candidates[i];
	        }
		}
	//TC:- O(2powN) *K 
	public static void main(String args[]) {
		int arr1[]= {1,2,3};
		int target1=7;
		int arr2[]= {10,1,2,7,6,1,5};
		int target2=8;
		GCombinationSum2 obj=new GCombinationSum2();
		System.out.println(obj.combinationSum2(arr1, target1)); 
		System.out.println(obj.combinationSum2(arr2, target2));
	}

}
