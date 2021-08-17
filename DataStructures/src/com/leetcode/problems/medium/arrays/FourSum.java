package com.leetcode.problems.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
     for(int i=0;i<nums.length-1;i++){
         for(int j=i+1;j<nums.length-2;j++){
             int l=j+1;
             int r=nums.length-1;
             while(l<r){
                 if(nums[i]+nums[j]+nums[l]+nums[r]==target){
                	 List iList=Arrays.asList(nums[i],nums[j],nums[l],nums[r]);
                     if(!list.contains(iList))
                        list.add(iList);
                     l++;
                     r--;
                 }else if(nums[i]+nums[j]+nums[l]+nums[r]<target){
                     l++;
                 }else {
                	 r--;
                 }
             }
         }
     }
        return list;
    }
	public static void main(String[] args) {
	int arr[]= {-2,-1,-1,1,1,2,2};
	int target=0;
	System.out.println(fourSum(arr, target));

	}

}
