package com.stivers.dp;

import java.util.Arrays;

public class OSubSetSum {
//Recursion
	public static boolean subsetSumToKRecur(int n, int k, int arr[]) {
		// Write your code here.
		return helper(0, arr, k, 0);
	}

	public static boolean helper(int inx, int arr[], int sum, int tempSum) {
		if (tempSum == sum) {
			return true;
		}
		if (inx == arr.length - 1) {
			if (tempSum + arr[arr.length - 1] == sum)
				return true;
			else
				return false;
		}
		tempSum += arr[inx];
		boolean take = helper(inx + 1, arr, sum, tempSum);
		tempSum -= arr[inx];
		boolean notTake = helper(inx + 1, arr, sum, tempSum);
		return take || notTake;
	}

//Memoization
	public static boolean subsetSumToKMemo(int n, int k, int arr[]) {
		// Write your code here.
		int dp[][] = new int[arr.length][k + 1];
		for (int ar[] : dp)
			Arrays.fill(ar, -1);

		return helper(0, arr, k, dp);
	}

	public static boolean helper(int inx, int arr[], int tempSum, int dp[][]) {
		if (tempSum == 0) {
			return true;
		}
		if (dp[inx][tempSum] != -1)
			return dp[inx][tempSum] == 1 ? true : false;
		if (inx == arr.length - 1) {
			if (tempSum - arr[arr.length - 1] == 0)
				return true;
			else
				return false;
		}
		boolean notTaken = helper(inx + 1, arr, tempSum, dp);
		boolean taken = false;
		if (arr[inx] <= tempSum)
			taken = helper(inx + 1, arr, tempSum - arr[inx], dp);
		dp[inx][tempSum] = (taken || notTaken) ? 1 : 0;
		return taken || notTaken;
	}

//Tabulation
	public static boolean subsetSumToKTab(int n, int k, int arr[]) {
		// Write your code here.
		boolean dp[][] = new boolean[n][k + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		if (arr[0] <= k)
			dp[0][arr[0]] = true;
		for (int ind = 1; ind < n; ind++) {
			for (int target = 1; target <= k; target++) {

				boolean notTaken = dp[ind - 1][target];

				boolean taken = false;
				if (arr[ind] <= target)
					taken = dp[ind - 1][target - arr[ind]];

				dp[ind][target] = notTaken || taken;
			}
		}

		return dp[n - 1][k];

	}

//Space optimization
	public static boolean subsetSumToKSpace(int n, int k, int arr[]) {
		// Write your code here.
		boolean prev[] = new boolean[k + 1];

		prev[0] = true;
		if (arr[0] <= k)
			prev[arr[0]] = true;

		for (int ind = 1; ind < n; ind++) {
			boolean curr[] = new boolean[k + 1];
			curr[0] = true;
			for (int target = 1; target <= k; target++) {

				boolean notTaken = prev[target];

				boolean taken = false;
				if (arr[ind] <= target)
					taken = prev[target - arr[ind]];

				curr[target] = notTaken || taken;
			}
			prev = curr;
		}

		return prev[k];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
