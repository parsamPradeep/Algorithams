package com.strivers.recursion;

import java.util.ArrayList;
import java.util.List;

public class NPrintAllSubArrElm {
    public static List<List<Integer>> numSubarrayProductLessThanK(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       for(int i=0;i<nums.length;i++){        
           for(int j=i;j<nums.length;j++){
               List<Integer> li=new ArrayList<>();
               for(int l=i;l<=j;l++){
                   li.add(nums[l]);
               }
              ans.add(new ArrayList<>(li));
           }
       }
       return ans;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  nums[]= {3,4,5,6,7,8,9,0};
		System.out.println(numSubarrayProductLessThanK(nums));
	}

}
