package com.leetcode.card.BST;

public class BinarySearch {
	public static int binarySearch(int arr[], int l, int r, int key) {
		if(l<=r) {
			int mid = l+(r-l)/2;
			if(key==arr[mid])
				return mid;
			if(key<arr[mid])
				return binarySearch(arr, l, mid-1, key);
			else 
				return binarySearch(arr, mid+1, r, key);
		}
		return -1;
	}
	public static void main(String[] args) {
		int arr[]= {5,6,8,8,8,10};
		int key=8;
		System.out.println(binarySearch(arr, 0, arr.length, key));
		

	}

}
