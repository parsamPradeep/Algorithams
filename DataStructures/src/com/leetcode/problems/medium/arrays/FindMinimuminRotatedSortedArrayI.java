package com.leetcode.problems.medium.arrays;

public class FindMinimuminRotatedSortedArrayI {
	 public static int findMin(int[] nums) {
	        if(nums.length==1)
	            return nums[0];
	        int min=Integer.MAX_VALUE;
	        int j=nums.length-1;
	        for(int i=0;i<=nums.length/2;i++){
	            if(nums[i]<min)
	                min=nums[i];
	            if(nums[j]<min)
	                min=nums[j];
	            j--;
	        }
	        return min;
	    }
	public static void main(String[] args) {
		int nums[]= {4,5,6,7,0,1,2};
		System.out.println(findMin(nums));

	}

}
