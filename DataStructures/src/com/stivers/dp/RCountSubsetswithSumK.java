package com.stivers.dp;

import java.util.Arrays;

public class RCountSubsetswithSumK {
//Recursion
	public int countRecur(int inx, int target, int arr[]) {
		if (inx == 0) {
			if (target == 0 && arr[0] == 0) {
				return 2;
			}
			if (target == 0 || arr[0] == target) {
				return 1;
			}
			return 0;
		}

		int notTaken = countRecur(inx - 1, target, arr);
		int taken = 0;
		if (arr[inx] <= target)
			taken = countRecur(inx - 1, target - arr[inx], arr);
		return notTaken + taken;

	}

//Memoization
	public int countMemo(int inx, int target, int arr[], int dp[][]) {
		if (inx == 0) {
			if (target == 0 && arr[0] == 0) {
				return 2;
			}
			if (target == 0 || arr[0] == target) {
				return 1;
			}
			return 0;
		}
		if(dp[inx][target]!=-1) return dp[inx][target];

		int notTaken = countMemo(inx - 1, target, arr, dp);
		int taken = 0;
		if (arr[inx] <= target)
			taken = countMemo(inx - 1, target - arr[inx], arr, dp);
		return dp[inx][target]=notTaken + taken;

	}
	
//Tabulation
	public int countTabu(int arr[], int target) {
		int dp[][]=new int[arr.length][target+1];
		for(int i=0;i<arr.length;i++)
			dp[i][0]=1;
		if(arr[0]<=target)
			dp[0][arr[0]]=1;
		for(int inx=1;inx<arr.length;inx++) {
			for(int tar=0;tar<=target;tar++) {
				int notTaken=dp[inx-1][tar];
				int taken = 0;
				if(arr[inx]<=tar)
					taken = dp[inx-1][tar-arr[inx]];
				dp[inx][tar]=notTaken+taken;
			}
		}
		return dp[arr.length-1][target];
	}

//Space optimization
	public int countSpaceOpt(int arr[], int k) {
		int prev[]=new int[k+1];
		prev[0]=1;
		if(arr[0]<=k)
			prev[arr[0]]=1;
		for(int inx=1;inx<arr.length;inx++) {
			int curr[]=new int[k+1];
			curr[0]=1;
			for(int target=1;target<=k;target++) {
				int notTaken=prev[target];
				int taken = 0;
				if(arr[inx]<=target)
					taken=prev[target-arr[inx]];
				curr[target]=notTaken+taken;
			}
			prev=curr;
		}
		return prev[k];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RCountSubsetswithSumK obj = new RCountSubsetswithSumK();
		int arr[] = { 1, 1, 4, 5 };
		int k=5;
		int dp[][]=new int[arr.length][k+1];
		for(int ar[]: dp)
			Arrays.fill(ar, -1);
		System.out.println(obj.countRecur(arr.length - 1, k, arr));// Ans 3
		System.out.println(obj.countMemo(arr.length - 1, k, arr, dp));// Ans 3
		System.out.println(obj.countTabu(arr,k));// Ans 3
		System.out.println(obj.countSpaceOpt(arr,k));// Ans 3
	}

}
