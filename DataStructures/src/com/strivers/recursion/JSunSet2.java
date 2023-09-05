package com.strivers.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSunSet2 {
	public void helper(int inx, int N, int arr[], List<Integer> tmpList,List<List<Integer>> ans) {
		if(inx>=N) return;
		ans.add(new ArrayList<>(tmpList));
		for(int i=inx; i<N;i++) {
			if(i>0 && arr[i]==arr[i-1]) continue;
			tmpList.add(arr[i]);
			helper(inx+1, N, arr, tmpList, ans);
			tmpList.remove((Integer)arr[i]);
		}
	}
	public List<List<Integer>> subset2(int arr[]){
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		helper(0, arr.length, arr, new ArrayList<>(), ans);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,2};
		JSunSet2 obj=new JSunSet2();
		System.out.println(obj.subset2(arr));
	}

}
