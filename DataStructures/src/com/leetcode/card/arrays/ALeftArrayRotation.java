package com.leetcode.card.arrays;

public class ALeftArrayRotation {
	// solution --- 1
	public static int[] leftRotation(int arr[], int d) {
		int n = arr.length;
		int roArray[] = new int[n];
		for (int i = 0; i < n; i++)
			roArray[(i + n - d) % n] = arr[i];
		return roArray;
	}

	// solution ----2
	public static int[] leftRotation2(int arr[], int d) {
		int n = arr.length;
		int ins_pos = n-d;
		int rArray[] = new int[n];
		int i=0;
		while (ins_pos < arr.length) {
			rArray[ins_pos]=arr[i];
			i++;
			ins_pos++;
		}
		ins_pos=0;
		while(ins_pos<(n-d)) {
			rArray[ins_pos]=arr[i];
			i++;
			ins_pos++;
		}
		return rArray;
			
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 7, 8, 9 };
		int res[] = leftRotation(arr, 2);

		for (int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}

}
