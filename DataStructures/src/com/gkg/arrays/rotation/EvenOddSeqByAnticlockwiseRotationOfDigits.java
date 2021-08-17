package com.gkg.arrays.rotation;
/*
even-odd sequence by anticlockwise rotation of digits

Given an array arr[] consisting of N positive integers, 
the task is to rotate the digits of array elements in an anti-clockwise direction 
such that elements of the array elements are in alternate even-odd or odd-even form.
If multiple solutions exists, then print any one of them. Otherwise, print -1.

Examples:

Input: arr[] = { 143, 251, 534, 232, 854 }
Output: 143 512 345 232 485
Explanation:
Rotating arr[1] by 1 in anticlockwise direction modifies arr[1] to 512.
Rotating arr[2] by 1 in anticlockwise direction modifies arr[2] to 345.
Rotating arr[4] by 2 in anticlockwise direction modifies arr[4] to 485.

Input: arr[] = { 44, 23, 21, 33, 14 }
Output: 44 23 12 33 14
 */
public class EvenOddSeqByAnticlockwiseRotationOfDigits {
	
	public static int[] rotate(int arr[]) {
		if(arr[0]%2==0) {
			for(int i=1;i<arr.length;i++) {
				if(i%2==0) {
					int odd=getEvenByRotate(arr[i]);
					arr[i]=odd;
				}else {
					int even=getOddByRotate(arr[i]);
					arr[i]=even;
				}
			}
		}else {
			for(int i=1;i<arr.length;i++) {
				if(i%2==0) {
					int odd=getOddByRotate(arr[i]);
					arr[i]=odd;
				}else {
					int even=getEvenByRotate(arr[i]);
					arr[i]=even;
				}
			}
		}
		return arr;
	}
	
	public static int getOddByRotate(int num) {

		int len=String.valueOf(num).length();
		int x=(int)Math.pow(10,len-1);
		int res=num;
		for(int i=0;i<len;i++) {
			int lastDigit=num%10;
			if(lastDigit%2!=0) {
				res=num;
				break;
			}
			num=num/10;
	
			num=num+(lastDigit*x);
			
			
		}
		return res;
	}
	public static int getEvenByRotate(int num) {
		
		int len=String.valueOf(num).length();
		int x=(int)Math.pow(10,len-1);
		int res=num;
		for(int i=0;i<len;i++) {
			int lastDigit=num%10;
			if(lastDigit%2==0) {
				res=num;
				break;
			}
			num=num/10;
	
			num=num+(lastDigit*x);
			
			
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[]= { 143, 251, 534, 232, 854 };
		int res[]=rotate(arr);
		for(int i:res)
			System.out.println(i);

	}

}
