package com.leetcode.card.arrays;

public class IRemoveDuplicatesInPlace {

	public static int removeDuplicates(int arr[]) {
		int i=0;
		for(int j=0;j<arr.length;j++) {
			if(arr[i]!=arr[j])
				i++;
			arr[i]=arr[j];
		}
		return i;
	}
	
	
	public static void main(String[] args) {
		int arr1[]= {0,1,2,2,3,0,4,2};
		int res1=removeDuplicates(arr1);
		for(int i=0;i<res1;i++) {
			System.out.print(arr1[i]);
		}

	}
}
