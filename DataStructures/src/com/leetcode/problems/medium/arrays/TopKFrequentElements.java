package com.leetcode.problems.medium.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	 public int[] topKFrequent(int[] nums, int k) {
	        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	        int res[]=new int[k];
	        int j=0;
	        for(int i=0;i<nums.length;i++){
	            if(map.containsKey(nums[i]))
	                map.put(nums[i],map.get(nums[i])+1);
	            else
	                map.put(nums[i],1);
	               
	        }

	
	    	
	                
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
