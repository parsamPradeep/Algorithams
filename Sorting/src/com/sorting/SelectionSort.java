package com.sorting;

public class SelectionSort {
	public static void selectionSorting(int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			int sel_inx=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[sel_inx]) {
					sel_inx=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[sel_inx];
			arr[sel_inx]=temp;
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
