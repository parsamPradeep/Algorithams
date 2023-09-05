package com.stivers.dp;

import java.util.Arrays;

public class JMinPathSum {
//Recursion
	public int minPathSumRec(int i, int j, int[][] grid) {
		if (i == 0 && j == 0)
			return grid[i][j];
		if (i < 0 || j < 0)
			return (int) Math.pow(10, 9);
		int up = grid[i][j] + minPathSumRec(i - 1, j, grid);
		int left = grid[i][j] + minPathSumRec(i, j - 1, grid);
		return Math.min(up, left);
	}

//Memoization
	public int minPathSumMemo(int[][] grid) {
		int dp[][] = new int[grid.length][grid[0].length];
		for (int arr[] : dp)
			Arrays.fill(arr, -1);
		return helper(grid.length - 1, grid[0].length - 1, grid, dp);
	}

	public int helper(int i, int j, int[][] grid, int dp[][]) {
		if (i == 0 && j == 0)
			return grid[i][j];
		if (i < 0 || j < 0)
			return (int) Math.pow(10, 9);
		if (dp[i][j] != -1)
			return dp[i][j];
		int up = grid[i][j] + helper(i - 1, j, grid, dp);
		int left = grid[i][j] + helper(i, j - 1, grid, dp);
		return dp[i][j] = Math.min(up, left);
	}

// Tabulation
	public int minPathSumTab(int[][] grid) {
		int dp[][] = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
					continue;
				}
				int up = grid[i][j];
				if (i > 0)
					up += dp[i - 1][j];
				else
					up += (int) Math.pow(10, 9);

				int left = grid[i][j];
				if (j > 0)
					left += dp[i][j - 1];
				else
					left += (int) Math.pow(10, 9);
				dp[i][j] = Math.min(left, up);

			}
		}
		return dp[grid.length - 1][grid[0].length - 1];
	}

// Space optimization
	public int minPathSum(int[][] grid) {

		int prev[] = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			int temp[] = new int[grid[0].length];
			for (int j = 0; j < grid[i].length; j++) {
				if (i == 0 && j == 0) {
					temp[j] = grid[i][j];
					continue;
				} else {
					int up = grid[i][j];
					if (i > 0)
						up += prev[j];
					else
						up += (int) Math.pow(10, 9);

					int left = grid[i][j];
					if (j > 0)
						left += temp[j - 1];
					else
						left += (int) Math.pow(10, 9);
					temp[j] = Math.min(left, up);
				}
			}
			prev = temp;
		}
		return prev[prev.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		JMinPathSum obj = new JMinPathSum();
		System.out.println(obj.minPathSumRec(arr.length - 1, arr[0].length - 1, arr)); // Ans 7
		System.out.println(obj.minPathSumMemo(arr));

	}

}
