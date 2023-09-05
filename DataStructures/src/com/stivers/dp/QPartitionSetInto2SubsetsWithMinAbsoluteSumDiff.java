package com.stivers.dp;

import java.util.Arrays;

public class QPartitionSetInto2SubsetsWithMinAbsoluteSumDiff {
//Memoization As unable to done with reccur - Hard level
	public static int minSubsetSumDifferenceMemo(int[] arr, int n) {
		int totalSum = 0;
		for (int i = 0; i < n; i++)
			totalSum += arr[i];
		int dp[][] = new int[n][totalSum + 1];
		for (int ar[] : dp)
			Arrays.fill(ar, -1);
		for (int i = 0; i <= totalSum; i++)
			helper(n - 1, i, arr, dp);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= totalSum; i++) {
			if (dp[n - 1][i] == 1) {
				int diff = Math.abs(i - (totalSum - i));
				min = Math.min(diff, min);
			}
		}
		return min;
	}

	public static boolean helper(int inx, int target, int[] arr, int dp[][]) {
		if (target == 0) {
			dp[inx][target] = 1;
			return true;
		}
		if (inx == 0) {
			dp[inx][target] = target - arr[inx] == 0 ? 1 : 0;
			return target - arr[inx] == 0;
		}
		if (dp[inx][target] != -1)
			return dp[inx][target] == 1 ? true : false;
		boolean noTaken = helper(inx - 1, target, arr, dp);
		boolean taken = false;
		if (arr[inx] <= target) {
			taken = helper(inx - 1, target - arr[inx], arr, dp);
		}
		dp[inx][target] = (noTaken || taken) ? 1 : 0;
		return noTaken || taken;
	}

// Tabulation
	public static int minSubsetSumDifferenceTab(int[] arr, int n) {
		int totalSum = 0;
		for (int i = 0; i < n; i++)
			totalSum += arr[i];
		boolean dp[][] = new boolean[n][totalSum + 1];
		for (int i = 0; i < arr.length; i++)
			dp[i][0] = true;
		if (arr[0] <= totalSum)
			dp[0][arr[0]] = true;
		for (int i = 1; i < n; i++) {
			for (int target = 1; target <= totalSum; target++) {
				boolean notTaken = dp[i - 1][target];
				boolean taken = false;
				if (arr[i] <= target)
					taken = dp[i - 1][target - arr[i]];
				dp[i][target] = notTaken || taken;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= totalSum; i++) {
			if (dp[n - 1][i]) {
				int diff = Math.abs(i - (totalSum - i));
				min = Math.min(diff, min);
			}
		}
		return min;
	}

//Space optimization
	public static int minSubsetSumDifference(int[] arr, int n) {
		int totalSum = 0;
		for (int i = 0; i < n; i++)
			totalSum += arr[i];
		boolean prev[] = new boolean[totalSum + 1];
		prev[0] = true;
		if (arr[0] <= totalSum)
			prev[arr[0]] = true;
		for (int i = 1; i < n; i++) {
			boolean curr[] = new boolean[totalSum + 1];
			curr[0] = true;
			for (int target = 1; target <= totalSum; target++) {
				boolean notTaken = prev[target];
				boolean taken = false;
				if (arr[i] <= target)
					taken = prev[target - arr[i]];
				curr[target] = notTaken || taken;
			}
			prev = curr;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= totalSum; i++) {
			if (prev[i]) {
				int diff = Math.abs(i - (totalSum - i));
				min = Math.min(diff, min);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {8, 6, 5};
		System.out.println(minSubsetSumDifferenceMemo(arr, arr.length));  //ans 3
	}

}
