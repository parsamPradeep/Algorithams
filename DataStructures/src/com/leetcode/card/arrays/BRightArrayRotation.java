package com.leetcode.card.arrays;

public class BRightArrayRotation {
	
	public static int [] rightRotation(int arr[], int d) {
		int n=arr.length;
		int roArray[]=new int[n];
		
		for(int i=0;i<n;i++)
			roArray[(i+d)%n]=arr[i];
		
		return roArray;
	}

	public static void main(String[] args) {
		int arr[]= {4,5,6,7,8,9,0,1,2};
		int res[]=rightRotation(arr, 2);
		
		for(int r=0;r<res.length;r++)
			System.out.println(res[r]);

	}

}
