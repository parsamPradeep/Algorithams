package com.leetcode.card.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UFindAllNumbersDisappearedinanArray {
	 public static List<Integer> findDisappearedNumbers(int[] nums) {
	        for(int i=0;i<nums.length;i++){
	            while(nums[i]!=i+1 && nums[i]!=nums[nums[i]-1]){
	                int tmp=nums[i];
	                nums[i]=nums[tmp-1];
	                nums[tmp-1]=tmp;
	            }
	        }
	        List<Integer> res=new ArrayList<>();
	         for(int i=0;i<nums.length;i++){
	             if(nums[i]!=(i+1))
	                 res.add(i+1);
	         }
	        return res;
	    }
	public static void main(String[] args) {
		int nums[]={5,4,6,7,9,3,10,9,5,6};
		System.out.println(findDisappearedNumbers(nums));
	}

}
