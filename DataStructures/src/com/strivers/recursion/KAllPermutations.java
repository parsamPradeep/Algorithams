package com.strivers.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KAllPermutations {
	 public List<List<Integer>> permute(int[] arr) {
		 List<List<Integer>> ans = new ArrayList<>();
	     helper(new ArrayList<>(), ans, arr, new boolean[arr.length]);
	     return ans;
	 } 
	public void helper(List<Integer> ds, List<List<Integer>> ans, int arr[], boolean freq[]) {
		if(ds.size()==arr.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!freq[i]) {
				ds.add(arr[i]);
				freq[i]=true;
				helper(ds, ans, arr, freq);
				ds.remove((Integer)arr[i]);
				freq[i]=false;
			}
		}
		
	}
	// TC:- n! * n SC:- O(n)+O(n)
//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
	 public List<List<Integer>> permute2(int[] nums) {
		 List<List<Integer>> ans=new ArrayList<>();
	        for(int i=0;i<=nums.length/2;i++){
	            for(int j=0;j<nums.length;j++){
	                List<Integer> list=new ArrayList<>();
	                for(int k:nums) list.add(k);
	                Integer temp=list.get(i);
	                list.set(i,list.get(j));
	                list.set(j,temp);
	                ans.add(list);
	            }
	        }
	        return ans;
	 }
	 public void helper2(int inx, int arr[], List<List<Integer>> ans) {
		 if(inx==arr.length) {
			 List<Integer> list=new ArrayList<>();
			 for(int i: arr) list.add(i);
			 ans.add(list);
			 return;
		 }
		 for(int i=inx;i<arr.length;i++) {
			 swap(i,inx,arr);
			 helper2(i+1, arr, ans);
			 swap(i,inx,arr);
		 }
	 }
		// TC:- n! * n SC:- O(n) -> axilary space
	 public void swap(int i,int j, int arr[]) {
		 int temp=arr[i];
		 arr[i]=arr[j];
		 arr[j]=temp;
	 }
	 
	 public List<List<Integer>> permute3(int arr[]){
		 List<List<Integer>> ans=new ArrayList<>();
		 helper2(0, arr, ans);
		 System.out.println(ans);
		 return ans;
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3};
		KAllPermutations obj=new KAllPermutations();
		System.out.println(obj.permute(arr));
		System.out.println(obj.permute2(arr));
		obj.permute3(arr);
	}

}
