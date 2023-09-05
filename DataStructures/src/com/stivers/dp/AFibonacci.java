package com.stivers.dp;

import java.util.Arrays;

public class AFibonacci {

// Recursion
	public int fibanacci(int n) {
		if (n <= 1)
			return n;
		return fibanacci(n - 1) + fibanacci(n - 2);
	}

// Memorization
	public int fibanacciMemo(int n, int dp[]) {
		if (n <= 1)
			return n;
		if (dp[n] != -1)
			return dp[n];
		return dp[n] = fibanacciMemo(n - 1, dp) + fibanacciMemo(n - 2, dp);
	}

// Tabulation
	public int fibannacciTabulation(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

// Space optimization
	public int fibanacciSpaceOpt(int n) {
		int prev2 = 0;
		int prev = 1;

		for (int i = 2; i <= n; i++) {
			int cur_i = prev2 + prev;
			prev2 = prev;
			prev = cur_i;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AFibonacci obj = new AFibonacci();
		System.out.println(obj.fibanacci(4));
		int dp[] = { -1, -1, -1, -1, -1 };
		System.out.println(obj.fibanacciMemo(4, dp));
		System.out.println(obj.fibannacciTabulation(4));
		System.out.println(obj.fibanacciSpaceOpt(4));
	}

}
