package com.algorithams;

public class TernarySearch {
	public static int ternarySearch(int arr[], int str, int end, int key) {
		
		if(end>=str) {
		int mid1=str+(end-str)/3;
		int mid2=mid1+(end-str)/3;
		if(arr[mid1]==key)
			return mid1;
		if(arr[mid2]==key)
			return mid2;
		if(key<arr[mid1])
			return ternarySearch(arr,str,mid1-1,key);
		if(key>arr[mid2])
			return ternarySearch(arr,mid2+1,end,key);
		if(key>arr[mid1]&&key<arr[mid2])
			return ternarySearch(arr,mid1+1,mid2-1,key);
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[]= {1,2,3,4,5,6,7,8};
		int key=7;
		int result=ternarySearch(arr,0,arr.length,key);
		if(result==-1) 
			System.out.println("not found");
			else
			System.out.println("fount at index :"+result);

	}

}
