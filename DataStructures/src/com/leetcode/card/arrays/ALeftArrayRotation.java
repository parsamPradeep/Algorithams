package com.leetcode.card.arrays;

public class ALeftArrayRotation {
	
	public static int[] leftRotation(int arr[], int d) {
		int n=arr.length;
		int roArray[]=new int[n];
		for(int i=0;i<n;i++)
			roArray[(i+n-d)%n]=arr[i];
		return roArray;
	}
	
	
	
	public static void main(String [] args) {
		int arr[]= {2,4,6,7,8,9};
		int res[]=leftRotation(arr, 2);
		
		for(int i=0;i<res.length;i++)
			System.out.println(res[i]);
	}

}
