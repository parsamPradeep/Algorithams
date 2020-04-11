package com.sorting;

public class BubbleSort {
	public static void bubbleSort(int arr[]) {
		//for optimised bubble sort
		boolean swap;
		for(int i=0;i<arr.length;i++) {
			swap=false;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swap=true;
				}
			}
			// If no elements are swapped in inner loop 
			// then break
			 if (swap == false) 
	                break; 
		}
		for(int inx:arr) {
			System.out.println(inx);
		}
		
	}

	public static void main(String[] args) {
		int arr[]= {20,2,45,6,77,8};
		bubbleSort(arr);
	}

}
