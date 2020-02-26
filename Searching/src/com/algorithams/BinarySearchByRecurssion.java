package com.algorithams;

public class BinarySearchByRecurssion {
	public static int binarySearch(int arr[], int str, int end,int key) {
		int mid=str+end/2;
		if(mid<=arr.length) {			
		if(arr[mid]==key)
			return mid;
		if(key<arr[mid]) 
			return binarySearch(arr, str, mid-1, key);
		
		return binarySearch(arr, mid+1, end, key);
		
	} 
		return -1;
	
	}
	public static void main (String [] agrs) {
		int arr[]= {1,2,3,4,5,6,7,8};
		int key=10;
		int n=arr.length-1;
		int result=binarySearch(arr,0,n,key);
		if(result==-1) 
			System.out.println("not found");
			else
			System.out.println("fount at index :"+result);
		
				
	}

}
