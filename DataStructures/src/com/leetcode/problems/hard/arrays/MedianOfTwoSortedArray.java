package com.leetcode.problems.hard.arrays;

public class MedianOfTwoSortedArray {
	
	// Approach - 2
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
	    int index1 = 0;
	    int index2 = 0;
	    int med1 = 0;
	    int med2 = 0;
	    for (int i=0; i<=(nums1.length+nums2.length)/2; i++) {
	        med1 = med2;
	        if (index1 == nums1.length) {
	            med2 = nums2[index2];
	            index2++;
	        } else if (index2 == nums2.length) {
	            med2 = nums1[index1];
	            index1++;
	        } else if (nums1[index1] < nums2[index2] ) {
	            med2 = nums1[index1];
	            index1++;
	        }  else {
	            med2 = nums2[index2];
	            index2++;
	        }
	    }

	    // the median is the average of two numbers
	    if ((nums1.length+nums2.length)%2 == 0) {
	        return (float)(med1+med2)/2;
	    }

	    return med2;
	}
	// Approach - 1
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int res[]=new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                res[k]=nums1[i];
                i++;
                k++;
            }else{
                res[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<nums1.length){
            res[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            res[k]=nums2[j];
            j++;
            k++;
        }
        int mid=res.length/2;
        if(res.length%2==0){
            return (double)(res[mid-1]+res[mid])/2;
        }
        return (long)res[mid];
    }
	public static void main(String[] args) {
	int nums1[]= {1,2};
	int nums2[]= {3,4};
	System.out.println(findMedianSortedArrays2(nums1, nums2));

	}

}
