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
		
		int l=0, r=arr.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(arr[mid]==key)
				return mid;
			if(key<arr[mid]) 
				r=mid-1;
			else
				l=mid+1;
		}
		return -1;

	}

	public static void main(String[] args) {
		int arr[] = { 7, 4, 3, 2, 5, 6, 1, 8 };
		int key = 1;
		int result = binarySearch(arr, key);
		if (result != -1) {
			System.out.println("key found at index :" + result);
		} else {
			System.out.println("key not found");
		}
	}

}
