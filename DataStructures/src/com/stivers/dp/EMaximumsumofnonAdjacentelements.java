package com.stivers.dp;

import java.util.Arrays;

public class EMaximumsumofnonAdjacentelements {
//Recursion
	//Recursion - 1
	public int maxSumRec1(int inx, int arr[]) {
		if(inx < 0) return 0;
		if(inx ==0) return arr[inx];
		int pick=arr[inx]+maxSumRec1(inx-2, arr);
		int notPick=0+maxSumRec1(inx-1, arr);
		return Math.max(pick, notPick);
	}
	//Recursion - 2
		public int maxSumRec2(int inx, int arr[]) {
			if(inx >= arr.length) return 0;
			if(inx ==arr.length-1) return arr[inx];
			int pick=arr[inx]+maxSumRec2(inx+2, arr);
			int notPick=0+maxSumRec2(inx+1, arr);
			return Math.max(pick, notPick);
		}
//Memoization
		//Memoization - 1
		public int maxSumMem1(int inx, int arr[], int dp[]) {
			if(inx < 0) return 0;
			if(inx ==0) return arr[inx];
			if(dp[inx]!=-1) return dp[inx];
			int pick=arr[inx]+maxSumMem1(inx-2, arr, dp);
			int notPick=0+maxSumMem1(inx-1, arr, dp);
			return Math.max(pick, notPick);
		}
		//Memoization - 2
			public int maxSumMem2(int inx, int arr[], int dp[]) {
				if(inx >= arr.length) return 0;
				if(inx ==arr.length-1) return arr[inx];
				int pick=arr[inx]+maxSumMem2(inx+2, arr, dp);
				int notPick=0+maxSumMem2(inx+1, arr, dp);
				return Math.max(pick, notPick);
			}
//Tabulation
			public int maxSumTab(int arr[]) {
				int dp[]=new int[arr.length];
				dp[0]=arr[0];
				dp[1]=Math.max(arr[1], arr[0]);
				for(int i=2;i<arr.length;i++) {
					dp[i]=Math.max(arr[i]+dp[i-2], dp[i-1]);
				}
				return dp[arr.length-1];
			}
			
//Space optimization
			public int maxSumSpace(int arr[]) {
				int prev1=0;
				int prev2=0;
				for(int i=0;i<arr.length;i++) {
					int temp=prev1;
					prev1=Math.max(arr[i]+prev2, prev1);
					prev2=temp;
				}
				return prev1;
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EMaximumsumofnonAdjacentelements obj = new EMaximumsumofnonAdjacentelements();
		 int arr[]={2,1,4,9};
		 int dp[]=new int[arr.length];
		 Arrays.fill(dp,-1);
		 System.out.println(obj.maxSumRec1(arr.length-1, arr));
		 System.out.println(obj.maxSumRec2(0, arr));
		 System.out.println(obj.maxSumMem1(arr.length-1, arr, dp));
		 System.out.println(obj.maxSumMem2(0, arr, dp));
		 System.out.println(obj.maxSumTab(arr));
	}

}
