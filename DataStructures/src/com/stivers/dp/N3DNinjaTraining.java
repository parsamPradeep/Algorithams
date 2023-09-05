package com.stivers.dp;

import java.util.Arrays;

public class N3DNinjaTraining {
//Recursion
	 public int cherryPickupRecur(int[][] grid) {
	        return helper(0,0,grid[0].length-1, grid);
	    }
	    public int helper(int i, int j1, int j2, int grid[][]){
	        if(j1<0 || j1>grid[0].length-1 ||j2<0 || j2>grid[0].length-1) return (int)Math.pow(-10, 9);
	        if(i==grid.length-1){
	            if(j1==j2) return grid[i][j1];
	            else return grid[i][j1]+grid[i][j2];
	        }

	        int maxi=Integer.MIN_VALUE;
	        for(int d1=-1;d1<=1;d1++){
	            for(int d2=-1;d2<=1;d2++){
	                int ans;
	                if(j1==j2){
	                    ans=grid[i][j1]+helper(i+1, j1+d1,j2+d2,grid);
	                }else{
	                    ans=grid[i][j1]+grid[i][j2]+helper(i+1, j1+d1,j2+d2,grid);
	                }
	                maxi=Math.max(maxi, ans);
	            }
	        }
	        return maxi;
	    }
//Memoization
	    public int cherryPickupMemo(int[][] grid) {
	        int dp[][][]=new int[grid.length][grid[0].length][grid[0].length];
	        for(int arr[][]: dp)
	            for(int arr2[]: arr)
	            Arrays.fill(arr2, -1);
	        return helper(0,0,grid[0].length-1, grid, dp);
	    }
	    public int helper(int i, int j1, int j2, int grid[][], int dp[][][]){
	        if(j1<0 || j1>grid[0].length-1 ||j2<0 || j2>grid[0].length-1) return (int)Math.pow(-10, 9);
	        if(i==grid.length-1){
	            if(j1==j2) return grid[i][j1];
	            else return grid[i][j1]+grid[i][j2];
	        }
	        if(dp[i][j1][j2] != -1 ) return dp[i][j1][j2];
	        int maxi=Integer.MIN_VALUE;
	        for(int d1=-1;d1<=1;d1++){
	            for(int d2=-1;d2<=1;d2++){
	                int ans;
	                if(j1==j2){
	                    ans=grid[i][j1]+helper(i+1, j1+d1,j2+d2,grid,dp);
	                }else{
	                    ans=grid[i][j1]+grid[i][j2]+helper(i+1, j1+d1,j2+d2,grid,dp);
	                }
	                maxi=Math.max(maxi, ans);
	            }
	        }
	        return dp[i][j1][j2] = maxi;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
