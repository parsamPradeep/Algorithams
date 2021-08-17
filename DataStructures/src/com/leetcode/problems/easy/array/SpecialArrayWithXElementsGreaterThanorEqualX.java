package com.leetcode.problems.easy.array;

/*
Example 1:

Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
Example 2:

Input: nums = [0,0]
Output: -1
Explanation: No numbers fit the criteria for x.
If x = 0, there should be 0 numbers >= x, but there are 2.
If x = 1, there should be 1 number >= x, but there are 0.
If x = 2, there should be 2 numbers >= x, but there are 0.
x cannot be greater since there are only 2 numbers in nums.
Example 3:

Input: nums = [0,4,3,0,4]
Output: 3
Explanation: There are 3 values that are greater than or equal to 3.
Example 4:

Input: nums = [3,6,7,7,0]
Output: -1
 */
public class SpecialArrayWithXElementsGreaterThanorEqualX {
	// Approach - 1
	public static int specialArray1(int nums[]) {
		int n = nums.length;
		int count[] = new int[n + 1];
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= n) {
				count[n] += 1;
			} else {
				count[nums[i]] += 1;
			}
		}
		for (int i = count.length - 1; i >= 0; i--) {
			res += count[i];
			if (res == i)
				return res;
		}
		return -1;
	}

	// Approach - 2
	public static int specialArray2(int[] nums) {
		int res = -1;
		for (int i = 0; i <= nums.length; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++)
				if (nums[j] >= i)
					count++;
			if (i == count)
				res = i;
		}
		return res;
	}

	public static void main(String[] args) {
		int nums[] = { 3, 5 };
		System.out.println(specialArray2(nums));

	}

}
