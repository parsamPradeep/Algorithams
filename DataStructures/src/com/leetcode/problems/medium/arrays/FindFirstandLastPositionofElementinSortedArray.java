package com.leetcode.problems.medium.arrays;

/**
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 * Input: nums = [3,3,3], target = 3 Output: [0,2] Example 3:
 * 
 * Input: nums = [], target = 0 Output: [-1,-1]
 * 
 */

public class FindFirstandLastPositionofElementinSortedArray {
	public static int binarySearch(int arr[], int l, int r, int key) {
		if (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == key)
				return mid;
			if (key < arr[mid])
				return binarySearch(arr, l, mid - 1, key);
			else
				return binarySearch(arr, mid + 1, r, key);
		}
		return -1;
	}

	public static int[] search(int arr[], int target) {
		int res[] = { -1, -1 };
		if (arr.length == 0)
			return res;
		int inx = binarySearch(arr, 0, arr.length - 1, target);
		if (inx != -1) {
			for (int i = inx; i < arr.length; i++) {
				if (arr[i] == target)
					res[1] = i;
				else
					break;
			}
			for (int i = inx; i >= 0; i--) {
				if (arr[i] == target)
					res[0] = i;
				else
					break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 3, 3 };
		int key = 3;
		int res[] = search(arr, key);
		for (int i : res)
			System.out.println(i);

	}

}
