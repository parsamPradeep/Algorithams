package com.leetcode.card.arrays;
/*
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
 */
public class NMovesZeros {
	public static int[] moveZeroes(int[] nums) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				nums[i] = nums[j];
				i++;
			}
		}
		for (int r = i; r < nums.length; r++)
			nums[r] = 0;
		return nums;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 3, 12 };
		int res[] = moveZeroes(arr);
		for (int i : res)
			System.out.println(i);

	}

}
