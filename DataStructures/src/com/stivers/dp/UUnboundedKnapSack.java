package com.stivers.dp;

import java.util.Arrays;

public class UUnboundedKnapSack {
//Recursion
	public static int unboundedKnapsackRecur(int n, int w, int[] profit, int[] weight) {
		return helper1(weight.length - 1, w, weight, profit);
	}

	public static int helper1(int inx, int w, int wt[], int val[]) {
		if (inx == 0) {
			return ((int) (w / wt[0])) * val[0];
		}
		int notTake = 0 + helper1(inx - 1, w, wt, val);
		int take = Integer.MIN_VALUE;
		if (wt[inx] <= w)
			take = val[inx] + helper1(inx, w - wt[inx], wt, val);
		return Math.max(notTake, take);
	}

//Memoization
	public static int unboundedKnapsackMemo(int n, int w, int[] profit, int[] weight) {
		// Write your code here.
		int dp[][] = new int[weight.length][w + 1];
		for (int arr[] : dp)
			Arrays.fill(arr, -1);
		return helper2(weight.length - 1, w, weight, profit, dp);
	}

	public static int helper2(int inx, int w, int wt[], int val[], int dp[][]) {
		if (inx == 0) {
			return ((int) (w / wt[0])) * val[0];
		}
		if (dp[inx][w] != -1)
			return dp[inx][w];
		int notTake = 0 + helper2(inx - 1, w, wt, val, dp);
		int take = Integer.MIN_VALUE;
		if (wt[inx] <= w)
			take = val[inx] + helper2(inx, w - wt[inx], wt, val, dp);
		return dp[inx][w] = Math.max(notTake, take);
	}

//Tabulation
	public static int unboundedKnapsackTabu(int n, int w, int[] profit, int[] weight) {
		// Write your code here.
		int dp[][] = new int[n][w + 1];
		for (int i = 0; i <= w; i++)
			dp[0][i] = ((int) (i / weight[0])) * profit[0];
		for (int i = 1; i < n; i++) {
			for (int cap = 0; cap <= w; cap++) {
				int notTaken = 0 + dp[i - 1][cap];
				int taken = Integer.MIN_VALUE;
				if (weight[i] <= cap)
					taken = profit[i] + dp[i][cap - weight[i]];
				dp[i][cap] = Math.max(notTaken, taken);
			}
		}
		return dp[n - 1][w];
	}

//Space optimization
	public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
		// Write your code here.
		int prev[] = new int[w + 1];
		for (int i = weight[0]; i <= w; i++)
			prev[i] = ((int) (i / weight[0])) * profit[0];
		for (int i = 1; i < n; i++) {
			for (int cap = 0; cap <= w; cap++) {
				int notTaken = 0 + prev[cap];
				int taken = Integer.MIN_VALUE;
				if (weight[i] <= cap)
					taken = profit[i] + prev[cap - weight[i]];
				prev[cap] = Math.max(notTaken, taken);
			}

		}
		return prev[w];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
