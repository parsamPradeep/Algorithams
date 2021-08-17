package com.leetcode.card.arrays;
/*
 Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
 */
public class GMergeSortedArray {
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int res[]=new int[m+n];
        
        int i=0,j=0,k=0;
        while(i<m&&j<nums2.length){
            if(nums1[i]<=nums2[j]){
                res[k]=nums1[i];
                i++;
            }else{
                res[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            res[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            res[k]=nums2[j];
            j++;
            k++;
        }
        return res;
    }

	public static void main(String[] args) {
		int num1[]= {1,2,3,0,0,0};
		int num2[]= {2,5,6};
		int m=3;
		int n=3;
		int res[]=merge(num1,m,num2,n);
		for(int i:res)
			System.out.println(i);
		

	}

}
