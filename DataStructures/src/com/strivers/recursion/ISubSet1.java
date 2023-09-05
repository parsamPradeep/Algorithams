package com.strivers.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ISubSet1 {
	public List<List<Integer>> subsets(int[] nums) {
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
//------------------------------------------------------------------------------------------------------------------
	public List<Integer> subSetSum(int arr[]){
		List<Integer> ans=new ArrayList<>();
		helper(0, arr.length, 0,ans, arr);
		Collections.sort(ans);
		return ans;
	}
	public void helper(int inx, int N, int sum, List<Integer> ans, int arr[]) {
		if(inx==N) {
			ans.add(sum);
			return;
		}
		helper(inx+1, N, sum+arr[inx], ans, arr);
		helper(inx+1, N, sum, ans, arr);
	}
	
//Power set
	public List<List<Integer>> powerSet(int arr[]){
		
		int n = arr.length;
		int power_set=(int)Math.pow(2, n);
		List<List<Integer>> ans = new ArrayList<>();
		for(int i=0;i<power_set;i++) {
			List<Integer> tem=new ArrayList<>();
			for(int j=0;j<n;j++) {
				if((i & (1<<j)) != 0) {
					tem.add(arr[j]);
				}
			}
			ans.add(new ArrayList<>(tem));
		}
		return ans;
	}
	
//-----------------------------------------------------------
	public List<List<Integer>> subSet(int arr[]){
		List<List<Integer>> ans=new ArrayList<>();
		helper2(0, ans, new ArrayList<>(), arr);
		return ans;
	}
	public void helper2(int inx, List<List<Integer>> ans, List<Integer> curCom, int arr[]) {
		if(inx==arr.length) {
			ans.add(new ArrayList<>(curCom));
			return;
		}
		curCom.add(arr[inx]);
		helper2(inx+1,ans , curCom, arr);
		curCom.remove((Integer)arr[inx]);
		helper2(inx+1,ans  , curCom, arr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISubSet1 obj=new ISubSet1();
		int arr[]= {1,2,3};
		System.out.println(obj.subsets(arr)); // all possible subset
		System.out.println(obj.subSetSum(arr)); // sum of each possible subset
		System.out.println(obj.powerSet(arr));
		System.out.println(obj.subSet(arr));
	}

}
