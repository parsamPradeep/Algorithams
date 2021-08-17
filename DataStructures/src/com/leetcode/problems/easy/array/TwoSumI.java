package com.leetcode.problems.easy.array;
/*
Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [0,1]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [0,2]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [0,1]
 */
import java.util.HashMap;
import java.util.Map;

public class TwoSumI {

	// Approach - 1
	public static int[] twoSum1(int arr[], int targer) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			Integer diff=(Integer)(targer-arr[i]);
			if(map.containsKey(diff)) {
				int retArr[]= {map.get(diff),i};
				return retArr;
			}
			map.put(arr[i], i);
		}
		return null;
		
	}
	
	// Approach - 2
	 public static int[] twoSum2(int[] nums, int target) {
	        
	        int res[]=new int[2];
	        for(int i=0;i<nums.length-1;i++){
	            for(int j=i+1;j<nums.length;j++)
	                if(nums[i]+nums[j]==target){
	                    res[0]=i;
	                    res[1]=j;
	                    break;
	                }
	        }
	        return res;
	    }
	 
	 // Approach - 3 
	 public static int[] twoSum3(int num[],int target) {
		 int l = 0, r = num.length - 1;
		    while (num[l] + num[r] != target) {
		        if (num[l] + num[r] > target) r--;
		        else l++;
		    }
		    return new int[]{l, r};
	 }
	public static void main(String[] args) {

		int arr[]= {2,7,11,15};
		int target=9;
		int res[]=twoSum3(arr, target);
		for(int i:res)
			System.out.println(i);

	}

}
