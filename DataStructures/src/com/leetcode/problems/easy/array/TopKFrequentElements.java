package com.leetcode.problems.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
      
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
               
        }
        Queue<Integer> pQueue = new PriorityQueue<>((n1,n2) -> map.get(n1)-map.get(n2));
       // PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for (int n: map.keySet()) {
        	pQueue.add(n);
            if (pQueue.size() > k) pQueue.poll();    
          }
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = pQueue.poll();
        }
               
        return top;
    
    }

	public static void main(String[] args) {
		int nums[]= {1,1,1,2,2,3};
		int res[]=topKFrequent(nums, 2);
		for(int i:res)
			System.out.println(i);
	}

}
