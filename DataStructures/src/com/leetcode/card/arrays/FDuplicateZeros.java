package com.leetcode.card.arrays;
/*
 Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

Example 2:

Input: [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3] 
 */
import java.util.LinkedList;
import java.util.Queue;

public class FDuplicateZeros {

	// Approach - 1
	public static int[] duplicateZero1(int arr[]) {
		int n = arr.length - 1;
		int possibleDups = 0;

		for (int i = 0; i <= n - possibleDups; i++) {
			if (arr[i] == 0) {
				possibleDups++;
			}
		}

		int last = n - possibleDups;
		for (int j = last; j >= 0; j--) {
			if (arr[j] == 0) {
				arr[j + possibleDups] = arr[j];
				possibleDups--;
				arr[j + possibleDups] = arr[j];
			} else {
				arr[j + possibleDups] = arr[j];
			}
		}
		return arr;
	}

	// Approach - 2
	public static int[] duplicateZero2(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = arr.length - 1; j > i; j--) {
					arr[j] = arr[j - 1];
				}
				i++;
			}
		}
		return arr;
	}

	// Approach - 3
	public static int[] duplicateZero3(int arr[]) {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
			if (arr[i] == 0)
				q.add(0);

			arr[i] = q.remove();
		}

		return arr;
	}

	public static void main(String[] args) {
		int nums1[] = { 1, 0, 2, 3, 0, 4, 5, 0 };
		int res1[] = duplicateZero1(nums1);

		int nums2[] = { 1, 0, 2, 3, 0, 4, 5, 0 };
		int res2[] = duplicateZero2(nums2);

		int nums3[] = { 1, 0, 2, 3, 0, 4, 5, 0 };
		int res3[] = duplicateZero3(nums3);
		for (int i : res1)
			System.out.print("res1 "+ i + " ");
		System.out.println();
		for (int i : res2)
			System.out.print("res2 " + i + " ");
		System.out.println();
		for (int i : res3)
			System.out.print("res3 " + i + " ");
	}

}
