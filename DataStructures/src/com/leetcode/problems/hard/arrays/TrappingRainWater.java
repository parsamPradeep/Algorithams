package com.leetcode.problems.hard.arrays;
// https://www.youtube.com/watch?v=ZI2z5pq0TqA
public class TrappingRainWater {
	 public static int trap(int[] height) {
		 int maxLeft=height[0];
	        int maxRight=height[height.length-1];
	        int i=0;
	        int j=height.length-1;
	        int ans=0;
	        while(i<j){
	            if(height[i]<=height[j]){
	                ans+=maxLeft-height[i]>0 ? (maxLeft-height[i]) : 0;
	                maxLeft=Math.max(height[++i], maxLeft);
	            }
	            else{
	                ans+=maxRight-height[j]>0 ? (maxRight-height[j]) : 0;
	                maxRight=Math.max(height[--j],maxRight);
	            }
	            
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0,1,0,2,1,0,1,3,2,1,2,1};
		trap(arr);
	}

}
