package com.stivers.dp;

import java.util.Arrays;

public class VRodCutting {
//Recursion
	public static int cutRodRecur(int price[], int n) {
		// Write your code here.
		return helper1(n - 1, n, price);
	}

	public static int helper1(int inx, int N, int val[]) {
		if (inx == 0)
			return N * val[0];

		int notTake = 0 + helper1(inx - 1, N, val);
		int take = Integer.MIN_VALUE;
		int rodLen = inx + 1;
		if (rodLen <= N)
			take = val[inx] + helper1(inx, N - rodLen, val);
		return Math.max(notTake, take);
	}

//Memoization
	public static int cutRodMemo(int price[], int n) {
		// Write your code here.
		int dp[][] = new int[n][n + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		return helper(n - 1, n, price, dp);
	}

	public static int helper(int inx, int N, int val[], int dp[][]) {
		if (inx == 0)
			return N * val[0];
		if (dp[inx][N] != -1)
			return dp[inx][N];
		int notTake = 0 + helper(inx - 1, N, val, dp);
		int take = Integer.MIN_VALUE;
		int rodLen = inx + 1;
		if (rodLen <= N)
			take = val[inx] + helper(inx, N - rodLen, val, dp);
		return dp[inx][N] = Math.max(notTake, take);
	}

//Tabulation
	public static int cutRodTab(int price[], int N) {
		int dp[][] = new int[N][N + 1];
		for (int i = 0; i <= N; i++)
			dp[0][i] = i * price[0];
		for (int inx = 1; inx < N; inx++) {
			for (int len = 0; len <= N; len++) {
				int notTake = 0 + dp[inx - 1][len];
				int take = Integer.MIN_VALUE;
				int rodLen = inx + 1;
				if (rodLen <= len)
					take = price[inx] + dp[inx][len - rodLen];
				dp[inx][len] = Math.max(notTake, take);
			}
		}
		return dp[N - 1][N];
	}

//Space optimization
	public static int cutRodSpece(int price[], int N) {
		int prev[] = new int[N + 1];
		for (int i = 0; i <= N; i++)
			prev[i] = i * price[0];
		for (int inx = 1; inx < N; inx++) {
			for (int len = 0; len <= N; len++) {
				int notTake = 0 + prev[len];
				int take = Integer.MIN_VALUE;
				int rodLen = inx + 1;
				if (rodLen <= len)
					take = price[inx] + prev[len - rodLen];
				prev[len] = Math.max(notTake, take);
			}
		}
		return prev[N];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 5, 7, 8, 10 };
		System.out.println(VRodCutting.cutRodSpece(arr, 5)); //12
	}

}
