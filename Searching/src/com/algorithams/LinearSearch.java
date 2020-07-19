package com.algorithams;

public class LinearSearch {
	public static int linearSearch(int arr[], int key) 
	{
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) {
				return i;
			}
		}
		return -1;
	}
	public static void main (String [] agrs) 
	{
		int arr[]= {1,2,3,4,5,6,7,8};
		int key=1;
		int n=arr.length-1;
		int result=linearSearch(arr,key);
		if(result==-1) 
			System.out.println("not found");
			else
			System.out.println("fount at index :"+result);
		
				
	}
}
