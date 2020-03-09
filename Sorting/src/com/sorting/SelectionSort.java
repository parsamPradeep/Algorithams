package com.sorting;

public class SelectionSort {
	public static void selectionSorting(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int inx:arr) {
			System.out.println(inx);
		}
	}

	public static void main(String[] args) {
		int arr[]= {7,5,4,8,3,2,6,1};
		selectionSorting(arr);

	}

}
