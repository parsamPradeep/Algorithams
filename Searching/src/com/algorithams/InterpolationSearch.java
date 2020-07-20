package com.algorithams;

public class InterpolationSearch {
	
	public static int interpolationSearch(int arr[],int key)
	 {
		
		int lo = 0, hi = (arr.length - 1); 
		
		
		while(lo <= hi && key >= arr[lo] && key <= arr[hi]) 
		{
			
			if (arr[lo] == key)
				return lo; 
				
			double temp=lo+(((double)(hi-lo)/(arr[hi]-arr[lo]))*(key-arr[lo]));
			int pos=(int)temp;
			
			System.out.println("pos :"+pos);
			if(arr[pos]==key)
				return pos;
			
			if(key>arr[pos])
				lo=pos+1;
			else
				hi=pos-1;
		}
		return -1;
	}
	public static void main(String[] args) {
		int arr[] = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
		int key = 47;
		int res=interpolationSearch(arr, key);
		if(res!=-1)
			System.out.println("key found at index :"+res);
		else
			System.out.println("key not found");
	}

}
