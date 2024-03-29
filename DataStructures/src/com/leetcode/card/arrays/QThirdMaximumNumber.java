package com.leetcode.card.arrays;

public class QThirdMaximumNumber {

	public static int thirdMax(int[] nums) {

		// taking long data type since array can contain Integer.MIN_VALUE
        long max = Long.MIN_VALUE, sMax = Long.MIN_VALUE, tMax = Long.MIN_VALUE;
        for (int i : nums) {
            if (i > max) {
                tMax = sMax;
                sMax = max;
                max = i;
            } else if (i > sMax && i != max) {
                tMax = sMax;
                sMax = i;
            } else if (i > tMax && i != sMax && i != max) {
                tMax = i;
            }
        }
		
		// if thirdMax was not updated, return the first Max
		
        return tMax == Long.MIN_VALUE ? (int) max : (int) tMax;

	}

	public static void main(String[] args) {
		int arr[]= {1,2,2,5,3,5};
		int res=thirdMax(arr);
		System.out.println(res);

	}

}
