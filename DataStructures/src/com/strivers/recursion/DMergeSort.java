package com.strivers.recursion;

public class DMergeSort {
	public void mergeSort(int arr[], int low, int high) {
		if (low >= high)
			return;
		int mid = (high + low) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	public void merge(int arr[], int low, int mid, int high) {
		int l = low;
		int r = mid + 1;
		int tempArr[] = new int[low + high+1];
		int i = 0;
		while (l <= mid && r <= high) {
			if (arr[l] <= arr[r]) {
				tempArr[i] = arr[l];
				i++;
				l++;
			} else {
				tempArr[i] = arr[r];
				i++;
				r++;
			}
		}
		while (r <= high) {
			tempArr[i] = arr[r];
			i++;
			r++;
		}
		while (l <= mid) {
			tempArr[i] = arr[l];
			i++;
			l++;
		}
		for(int j=low;j<=high;j++)
			arr[j]=tempArr[j-low];

	}
// TC:- O(n log2 N)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 4, 3, 2, 7, 9 };
		DMergeSort obj = new DMergeSort();
		obj.mergeSort(arr, 0, arr.length-1);
		for(int i:arr)
			System.out.println(i);
	}

}
