package com.algorithams;

public class BinarySearch {
	public static int binarySearch(int arr[], int key) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		int mid = arr.length / 2;
		for (int i = 0; i < arr.length; i++) {

			if (key < arr[mid]) {

				for (int j = 0; j <= mid; j++) {
					if (key == arr[j]) {
						return j;
					}
				}
			} else {

				for (int k = mid; k < arr.length; k++) {
					if (key == arr[k]) {
						return k;
					}
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int arr[] = { 7, 4, 3, 2, 5, 6, 1, 8 };
		int key = 7;
		int result = binarySearch(arr, key);
		if (result != -1) {
			System.out.println("key found at index :" + result);
		} else {
			System.out.println("key not found");
		}
	}

}
