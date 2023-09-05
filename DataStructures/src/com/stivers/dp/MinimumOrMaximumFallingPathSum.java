package com.stivers.dp;

import java.util.Arrays;

public class MinimumOrMaximumFallingPathSum {
//Recursion
	public int minFallingPathSumRecur(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int maxi = Integer.MAX_VALUE;

		for (int j = 0; j < m; j++) {
			int ans = helper1(0, j, m, matrix);
			maxi = Math.min(maxi, ans);
		}

		return maxi;
	}

	public int helper1(int i, int j, int m, int[][] matrix) {

		// Base Conditions
		if (j < 0 || j >= m)
			return (int) Math.pow(10, 9);
		if (i == matrix.length - 1)
			return matrix[i][j];

		int down = matrix[i][j] + helper1(i + 1, j, m, matrix);
		int leftDiagonal = matrix[i][j] + helper1(i + 1, j - 1, m, matrix);
		int rightDiagonal = matrix[i][j] + helper1(i + 1, j + 1, m, matrix);

		return Math.min(down, Math.min(leftDiagonal, rightDiagonal));

	}

//Memoization
	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int dp[][] = new int[n][m];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		int maxi = Integer.MAX_VALUE;

		for (int j = 0; j < m; j++) {
			int ans = helper2(0, j, m, matrix, dp);
			maxi = Math.min(maxi, ans);
		}

		return maxi;
	}

	public int helper2(int i, int j, int m, int[][] matrix, int[][] dp) {

		// Base Conditions
		if (j < 0 || j >= m)
			return (int) Math.pow(10, 9);
		if (i == matrix.length - 1)
			return matrix[i][j];

		if (dp[i][j] != -1)
			return dp[i][j];

		int down = matrix[i][j] + helper2(i + 1, j, m, matrix, dp);
		int leftDiagonal = matrix[i][j] + helper2(i + 1, j - 1, m, matrix, dp);
		int rightDiagonal = matrix[i][j] + helper2(i + 1, j + 1, m, matrix, dp);

		return dp[i][j] = Math.min(down, Math.min(leftDiagonal, rightDiagonal));

	}

//Tabulation
	public int minFallingPathSumTab(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int dp[][] = new int[n][m];
		for (int i = 0; i < matrix[0].length; i++)
			dp[0][i] = matrix[0][i];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int up = matrix[i][j] + dp[i - 1][j];
				int leftDiagonal = matrix[i][j];
				int rightDiagonal = matrix[i][j];
				if (j - 1 >= 0)
					leftDiagonal += dp[i - 1][j - 1];
				else
					leftDiagonal += (int) Math.pow(10, 9);
				if (j + 1 < m)
					rightDiagonal += dp[i - 1][j + 1];
				else
					rightDiagonal += (int) Math.pow(10, 9);
				dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
			}
		}

		int maxi = Integer.MAX_VALUE;

		for (int j = 0; j < m; j++) {
			maxi = Math.min(maxi, dp[n - 1][j]);
		}

		return maxi;
	}

//SpaceOptimization
	 public int minFallingPathSumSpaceOpt(int[][] matrix) {
	       int n = matrix.length;
	    int m = matrix[0].length;
	    
	    int prev[]= new int[m];
	    for(int i=0;i<matrix[0].length;i++)
	        prev[i]=matrix[0][i];
	    
	    for(int i=1;i<n;i++){
	        int curr[]=new int[m];
	      for(int j=0; j<m;j++){
	         int up = matrix[i][j] + prev[j];
	         int leftDiagonal = matrix[i][j];
	         int rightDiagonal = matrix[i][j];
	         if(j-1>=0) 
	            leftDiagonal+= prev[j-1];
	        else
	            leftDiagonal+=(int)Math.pow(10,9);
	        if(j+1<m)
	          rightDiagonal += prev[j+1];
	        else
	            rightDiagonal += (int)Math.pow(10,9);
	         curr[j]= Math.min(up,Math.min(leftDiagonal,rightDiagonal));
	      }
	      prev=curr;
	    }

	    int maxi = Integer.MAX_VALUE;
	    
	    for(int j=0; j<m;j++){
	        maxi = Math.min(maxi,prev[j]);
	    }
	    
	    return maxi;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
