package com.stivers.dp;

import java.util.Arrays;

public class TMinimumCoins {
//Recursion
	public static int minimumElementsRecur(int num[], int x) {
		// Write your code here..
		int ans = helper1(num.length - 1, x, num);
		if (ans >= (int) Math.pow(10, 9))
			return -1;
		return ans;
	}

	public static int helper1(int inx, int T, int arr[]) {
		if (inx == 0) {
			if (T % arr[inx] == 0)
				return T / arr[inx];
			else
				return (int) Math.pow(10, 9);
		}
		int notTaken = 0 + helper1(inx - 1, T, arr);
		int taken = (int) Math.pow(10, 9);
		if (arr[inx] <= T)
			taken = 1 + helper1(inx, T - arr[inx], arr);
		return Math.min(taken, notTaken);
	}

//Memoization
	public static int minimumElementsMemo(int num[], int x) {
		// Write your code here..
		int dp[][] = new int[num.length][x + 1];
		for (int arr[] : dp)
			Arrays.fill(arr, -1);
		int ans = helper2(num.length - 1, x, num, dp);
		if (ans >= (int) Math.pow(10, 9))
			return -1;
		return ans;
	}

	public static int helper2(int inx, int T, int arr[], int dp[][]) {
		if (inx == 0) {
			if (T % arr[inx] == 0)
				return T / arr[inx];
			else
				return (int) Math.pow(10, 9);
		}
		if (dp[inx][T] != -1)
			return dp[inx][T];
		int notTaken = 0 + helper2(inx - 1, T, arr, dp);
		int taken = (int) Math.pow(10, 9);
		if (arr[inx] <= T)
			taken = 1 + helper2(inx, T - arr[inx], arr, dp);
		return dp[inx][T] = Math.min(taken, notTaken);
	}

//Tabulation
	public static int minimumElementsTab(int num[], int x) {
		// Write your code here..
		int dp[][] = new int[num.length][x + 1];
		for (int i = 0; i <= x; i++) {
			if (i % num[0] == 0)
				dp[0][i] = i / num[0];
			else
				dp[0][i] = (int) Math.pow(10, 9);
		}
		for (int i = 1; i < num.length; i++) {
			for (int j = 0; j <= x; j++) {
				int notTaken = 0 + dp[i - 1][j];
				int taken = (int) Math.pow(10, 9);
				if (num[i] <= j)
					taken = 1 + dp[i][j - num[i]];
				dp[i][j] = Math.min(notTaken, taken);
			}
		}

		if (dp[num.length - 1][x] >= (int) Math.pow(10, 9))
			return -1;
		return dp[num.length - 1][x];
	}

//Space Optmization
	public static int minimumElementsSpace(int num[], int x) {
		// Write your code here..
		int temp[] = new int[x + 1];
		int curr[] = new int[x + 1];
		for (int i = 0; i <= x; i++) {
			if (i % num[0] == 0)
				temp[i] = i / num[0];
			else
				temp[i] = (int) Math.pow(10, 9);
		}
		for (int i = 1; i < num.length; i++) {

			for (int j = 0; j <= x; j++) {
				int notTaken = 0 + temp[j];
				int taken = (int) Math.pow(10, 9);
				if (num[i] <= j)
					taken = 1 + temp[j - num[i]];
				curr[j] = Math.min(notTaken, taken);
			}
			temp = curr;
		}

		if (temp[x] >= (int) Math.pow(10, 9))
			return -1;
		return temp[x];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
