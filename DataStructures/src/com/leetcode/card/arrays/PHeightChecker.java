package com.leetcode.card.arrays;

/*
Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
Current array : [1,1,4,2,1,3]
Target array  : [1,1,1,2,3,4]
On index 2 (0-based) we have 4 vs 1 so we have to move this student.
On index 4 (0-based) we have 1 vs 3 so we have to move this student.
On index 5 (0-based) we have 3 vs 4 so we have to move this student.
 */
import java.util.Arrays;

public class PHeightChecker {
	public static int heightChecker(int[] heights) {

		int count = 0;
		int arr[] = heights.clone();
		Arrays.sort(arr);
		for (int i = 0; i < heights.length; i++) {
			if (arr[i] != heights[i]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 4, 2, 1, 3 };
		int count = heightChecker(arr);
		System.out.println(count);

	}

}
