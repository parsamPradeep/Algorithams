package com.leetcode.problems.easy.array;

public class BestTimetoBuyandSellStockI {
	public static int maxProfit(int arr[]) {
		int minValue=Integer.MAX_VALUE;
		int maxProfit=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<minValue)
				minValue=arr[i];
			else if(arr[i]-minValue>maxProfit)
				maxProfit=arr[i]-minValue;
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		int arr[]= {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));

	}

}
