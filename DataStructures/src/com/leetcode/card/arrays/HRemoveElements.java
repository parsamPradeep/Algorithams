package com.leetcode.card.arrays;

/*
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length. 
For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3]
Explanation: Your function should return length = 5, 
with the first five elements of nums containing 0, 1, 3, 0, and 4. 
Note that the order of those five elements can be arbitrary. 
It doesn't matter what values are set beyond the returned length.
 */
public class HRemoveElements {
	
	//Approach 1
	public static int removeElement1(int[] nums, int val) {
		int i=0;
        for(int j=0;j<nums.length;j++){
           if(nums[j]!=val) {
        	   nums[i]=nums[j];
        	   i++;
           }
        }
        return i;
    }
	
	// Approach 2
	public static int removeElement2(int[] nums, int val) {
		int n=nums.length,i=0;
		while(i<n) {
			if(nums[i]==val) {
				nums[i]=nums[n-1];
				n--;
			}else {
				i++;
			}
		}
		return n;
	}
	public static void main(String[] args) {
		int arr1[]= {0,1,2,2,3,0,4,2};
		int res1=removeElement1(arr1,2);
		
		int arr2[]= {0,1,2,2,3,0,4,2};
		int res2=removeElement2(arr2,2);
		
		for(int i=0;i<res1;i++) {
			System.out.print(arr1[i]);
		}
		System.out.println();
		for(int i=0;i<res2;i++) {
			System.out.print(arr2[i]);
		}

	}

}
