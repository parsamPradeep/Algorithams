package com.stivers.dp;

import java.util.Arrays;

public class BClimbingStairs {
	// Recursion
		public int climb(int n) {
			if (n <= 1)
				return n;
			return climb(n - 1) + climb(n - 2);
		}

	// Memorization
		public int climbMemo(int n, int dp[]) {
			if (n <= 1)
				return n;
			if (dp[n] != -1)
				return dp[n];
			return dp[n] = climbMemo(n - 1, dp) + climbMemo(n - 2, dp);
		}

	// Tabulation
		public int climbTabulation(int n) {
			int dp[] = new int[n + 1];
			Arrays.fill(dp, -1);
			dp[0] = 1;
			dp[1] = 1;

			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			return dp[n];
		}

	// Space optimization
		public int climbSpaceOpt(int n) {
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

	}

}
