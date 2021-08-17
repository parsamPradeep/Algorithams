package com.leetcode.problems.easy.array;

public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
        int inx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                inx= i;
                break;
            }
            if(target<=nums[i]){
                inx= i;
                break;
            }
        }
        return target>nums[nums.length-1]?nums.length:inx;
    }
	public static void main(String[] args) {
		int arr[]= {1,3,5,6};
		int target=7;
		System.out.println(searchInsert(arr, target));

	}

}
