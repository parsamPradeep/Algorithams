package com.leetcode.card.arrays;

public class BRightArrayRotation {
	// solution ---1
	public static int [] rightRotation(int arr[], int d) {
		int n=arr.length;
		int roArray[]=new int[n];
		
		for(int i=0;i<n;i++)
			roArray[(i+d)%n]=arr[i];
		
		return roArray;
	}
	
	// solution ----2
		public static int[] rightRotation2(int arr[], int d) {
			int n = arr.length;
			int ins_pos = d;
			int rArray[] = new int[n];
			int i=0;
			while (ins_pos < arr.length) {
				rArray[ins_pos]=arr[i];
				i++;
				ins_pos++;
			}
			ins_pos=0;
			while(ins_pos<d) {
				rArray[ins_pos]=arr[i];
				i++;
				ins_pos++;
			}
			return rArray;
				
		}

	public static void main(String[] args) {
		int arr[]= {4,5,6,7,8,9,0,1,2};
		int res[]=rightRotation(arr, 2);
		
		for(int r=0;r<res.length;r++)
			System.out.println(res[r]);

	}

}
