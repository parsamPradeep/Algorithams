package com.leetcode.card.arrays;

/*
Given an array A of non-negative integers,
return an array consisting of all the even elements of A, followed by all the odd elements of A.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class OSortArrayByParity {
	public static int[] sortArrayByParity(int[] A) {
		int i = 0;
		for (int j = 0; j < A.length; j++) {
			if (A[j] % 2 == 0) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 2, 4 };
		int res[] = sortArrayByParity(arr);

		for (int i : res)
			System.out.println(i);
	}

}
