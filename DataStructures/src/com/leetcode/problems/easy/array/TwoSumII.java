package com.leetcode.problems.easy.array;
/*
 Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
 */
public class TwoSumII {
	public static int[] twoSum(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		while (numbers[l] + numbers[r] != target) {
			if (numbers[l] + numbers[r] > target)
				r--;
			else
				l++;
		}
		return new int[] { l + 1, r + 1 };
	}

	public static void main(String[] args) {
		int arr[] = { 2, 7, 11, 15 };
		int target = 13;
		int res[] = twoSum(arr, target);
		for (int i : res)
			System.out.println(i);
	}

}
