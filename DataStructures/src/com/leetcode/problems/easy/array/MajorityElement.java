package com.leetcode.problems.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	// Approach - 1
	public static int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	// Approach - 2
	public static int majorityElement2(int arr[]) {
		int num=0;
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(count==0)
				num=arr[i];
			if(num==arr[i])
				count++;
			else
				count--;
				
		}
		return num;
		
	}
	
	
	// Approach - 3
	public static int majorityElement3(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
     int max=0;
     int num=0;
        for(int i=0;i<nums.length;i++){
             if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                 map.put(nums[i],map.get(nums[i])+1);
             }
             if(map.get(nums[i])>nums.length/2) {
            	 max=map.get(nums[i]);
            		num=nums[i];
             }
        }
       
        return num;
    }
	

	public static void main(String[] args) {
		int arr[]={3,2,3};
		int res=majorityElement1(arr);
		System.out.println(res);
	}

}
