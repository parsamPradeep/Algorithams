package com.leetcode.card.arrays;
/*
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */
public class CMaxConsicutiveOnes {
	
	static int findMaxConsecutiveOnes(int arr[]) 
    { 
         int n=arr.length;
        int count = 0; 
        int result = 0;
      
        for (int i = 0; i < n; i++) 
        { 
            if (arr[i] == 0) 
                count = 0; 
            else
            { 
                count++;//increase count 
                result = Math.max(result, count); 
            } 
        } 
      
        return result; 
    } 
      
	
	

	public static void main(String[] args) {
		int arr[]= {1,1,0,1,1,1};
		int res=findMaxConsecutiveOnes(arr);
		System.out.println(res);
		}

}
