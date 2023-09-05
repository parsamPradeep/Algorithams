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
	// solution --- 1
	public static int[] sortArrayByParity(int[] A) {
		int i = 0;
		for (int j = 1; j < A.length; j++) {
			if (A[j] % 2 == 0) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
			}
		}
		return A;
	} 

	// solution ---- 2
public static int[] sortArrayByParity2(int[] A) {
	int i=0;
	int n=A.length-1;
	while(i<n) {
		if(A[i]%2!=0) {
			if(A[n]%2==0) {
				int temp=A[n];
				A[n]=A[i];
				A[i]=temp;
				n--;
				i++;
			}else {
				n--;
			}
		}else {
			i++;
		}
	}
	return A;
}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 2, 4 };
		int res[] = sortArrayByParity2(arr);

		for (int i : res)
			System.out.println(i);
	}

}
