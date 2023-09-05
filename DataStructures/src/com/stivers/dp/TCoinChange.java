package com.stivers.dp;

import java.util.Arrays;

public class TCoinChange {
//Recursion
	public int changeRecur(int amount, int[] coins) {

		return helper2(coins.length - 1, amount, coins);
	}

	public int helper2(int inx, int target, int[] arr) {
		if (inx == 0) {
			if (target % arr[0] == 0)
				return 1;
			else
				return 0;
		}
		int notTaken = helper2(inx - 1, target, arr);
		int taken = 0;
		if (arr[inx] <= target)
			taken = helper2(inx, target - arr[inx], arr);
		return notTaken + taken;
	}

//Memoization
	public int changeMemo(int amount, int[] coins) {
		int dp[][] = new int[coins.length][amount + 1];
		for (int arr[] : dp)
			Arrays.fill(arr, -1);
		return helper1(coins.length - 1, amount, coins, dp);
	}

	public int helper1(int inx, int target, int[] arr, int dp[][]) {
		if (inx == 0) {
			if (target % arr[0] == 0)
				return 1;
			else
				return 0;
		}
		if (dp[inx][target] != -1)
			return dp[inx][target];
		int notTaken = helper1(inx - 1, target, arr, dp);
		int taken = 0;
		if (arr[inx] <= target)
			taken = helper1(inx, target - arr[inx], arr, dp);
		return dp[inx][target] = notTaken + taken;
	}

	// Tabulation
	public int changeTab(int amount, int[] coins) {
		int dp[][] = new int[coins.length][amount + 1];
		for (int i = 0; i <= amount; i++)
			if (i % coins[0] == 0)
				dp[0][i] = 1;
		;
		for (int i = 1; i < coins.length; i++) {
			for (int j = 0; j <= amount; j++) {
				int notTaken = dp[i - 1][j];
				int taken = 0;
				if (coins[i] <= j)
					taken = dp[i][j - coins[i]];
				dp[i][j] = notTaken + taken;
			}
		}
		return dp[coins.length - 1][amount];
	}

	// Space optimization
	public int change(int amount, int[] coins) {
		int temp[] = new int[amount + 1];
		for (int i = 0; i <= amount; i++)
			if (i % coins[0] == 0)
				temp[i] = 1;
		;
		for (int i = 1; i < coins.length; i++) {
			for (int j = 0; j <= amount; j++) {
				int notTaken = temp[j];
				int taken = 0;
				if (coins[i] <= j)
					taken = temp[j - coins[i]];
				temp[j] = notTaken + taken;
			}
		}
		return temp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
