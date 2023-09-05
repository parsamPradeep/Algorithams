package com.strivers.recursion;

public class EQuickSort {
	
	public void quickSort(int arr[], int low, int high) {
		if(low<high) {
			int pIndex=partition(arr, low, high);
			quickSort(arr, low, pIndex-1);
			quickSort(arr, pIndex+1, high);
		}
	}
	
	public int partition(int arr[], int low, int high) {
		int pivot = arr[low];
		int i=low;
		int j=high;
		while(i<j) {
			while(arr[i]<=pivot && i<=high-1) {
				i++;
			}
			while(arr[j]>pivot && j>=low+1) {
				j--;
			}
			if(i<j) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[low];
		arr[low]=arr[j];
		arr[j]=temp;
		return j;
	}
	//TC:- NlogN SC:- O(1)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 4, 3, 2, 7, 9 };
		EQuickSort obj = new EQuickSort();
		obj.quickSort(arr, 0, arr.length-1);
		for(int i:arr)
			System.out.println(i);
	}
}
