package com.sorting;

public class InsertionSort {
	
	public static void insertionSort(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[i]) {
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
		for(int inx:arr) {
			System.out.println(inx);
		}
	}
	public static void main(String [] args) {
		int arr[]= {12,34,11,15,77};
		insertionSort(arr);
	}

}
