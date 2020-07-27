package com.algorithams;

import java.util.Arrays;

public class ExponentialSearch {

	public static int exponentialSearch(int arr[], int key) {
		int i = 1;
		while (i < arr.length && key > arr[i])
			i = i * 2;
		return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length), key);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 31, 36, 48, 77, 81, 98 };
		int key = 77;
		int result = exponentialSearch(arr, key);
		if (result != -1) {
			System.out.println("key found at index :" + result);
		} else {
			System.out.println("key not found");
		}
	}

}
