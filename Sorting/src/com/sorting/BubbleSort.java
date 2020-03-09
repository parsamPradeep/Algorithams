package com.sorting;

public class BubbleSort {
	public static void bubbleSort(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int inx:arr) {
			System.out.println(inx);
		}
		
	}

	public static void main(String[] args) {
		int arr[]= {20,21,45,67,77,87};
		bubbleSort(arr);
	}

}
