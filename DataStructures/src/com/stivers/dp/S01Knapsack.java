package com.stivers.dp;

import java.util.Arrays;

public class S01Knapsack {
//Memoization
	public int knapsack(int[] weight, int[] value, int n, int maxWeight) {
		int dp[][] = new int[weight.length][maxWeight + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return helper(weight, value, n - 1, maxWeight, dp);

	}

	public int helper(int wt[], int val[], int ind, int W, int dp[][]) {

		if (ind == 0) {
			if (wt[0] <= W)
				return val[0];
			else
				return 0;
		}

		if (dp[ind][W] != -1)
			return dp[ind][W];

		int notTaken = 0 + helper(wt, val, ind - 1, W, dp);

		int taken = Integer.MIN_VALUE;
		if (wt[ind] <= W)
			taken = val[ind] + helper(wt, val, ind - 1, W - wt[ind], dp);

		return dp[ind][W] = Math.max(notTaken, taken);
	}

//Tabulation
	public int knapsackTab(int[] weight, int[] value, int n, int maxWeight) {
		int dp[][] = new int[weight.length][maxWeight + 1];
		for (int i = weight[0]; i <= maxWeight; i++)
			dp[0][i] = value[0];
		for (int i = 1; i < value.length; i++) {
			for (int w = 0; w <= maxWeight; w++) {
				int notTaken = 0 + dp[i - 1][w];
				int taken = Integer.MIN_VALUE;
				if (weight[i] <= w)
					taken = value[i] + dp[i - 1][w - weight[i]];
				dp[i][w] = Math.max(notTaken, taken);
			}
		}
		return dp[weight.length - 1][maxWeight];

	}

//Space optimization
	public int knapsackSpace(int[] weight, int[] value, int n, int maxWeight) {
		int prev[] = new int[maxWeight + 1];
		for (int i = weight[0]; i <= maxWeight; i++)
			prev[i] = value[0];
		for (int i = 1; i < value.length; i++) {
			int curr[] = new int[maxWeight + 1];
			for (int w = 0; w <= maxWeight; w++) {
				int notTaken = 0 + prev[w];
				int taken = Integer.MIN_VALUE;
				if (weight[i] <= w)
					taken = value[i] + prev[w - weight[i]];
				curr[w] = Math.max(notTaken, taken);
			}
			prev = curr;
		}
		return prev[maxWeight];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
