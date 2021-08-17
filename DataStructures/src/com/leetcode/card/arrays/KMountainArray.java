package com.leetcode.card.arrays;
/*
Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 */
public class KMountainArray {
	public static boolean mountainArray(int arr[]) {
		int N = arr.length;
		int i = 0;
		while (i + 1 < N && arr[i] < arr[i + 1])
			i++;
		if (i == 0 || i == N - 1)
			return false;
		while (i + 1 < N && arr[i] > arr[i + 1])
			i++;

		return i == N - 1;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 3, 2, 1 };
		boolean res = mountainArray(arr);
		System.out.println(res);

	}

}
