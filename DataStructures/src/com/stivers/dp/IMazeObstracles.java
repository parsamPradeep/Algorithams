package com.stivers.dp;

import java.util.Arrays;

public class IMazeObstracles {
//Recursion
	public int mazeObstaclesUtil(int i, int j, int[][] maze) {
		if (i >=0 && j >= 0 && maze[i][j] == -1)
			return 0;
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;

		int up = mazeObstaclesUtil(i - 1, j, maze);
		int left = mazeObstaclesUtil(i, j - 1, maze);

		return up + left;

	}

//Memoization
	public int mazeObstaclesMemo(int i, int j, int[][] maze, int[][] dp) {
		if (i >= 0 && j > 0 && maze[i][j] == -1)
			return 0;
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		int up = mazeObstaclesMemo(i - 1, j, maze, dp);
		int left = mazeObstaclesMemo(i, j - 1, maze, dp);

		return dp[i][j] = up + left;

	}

//Tabulation
	public int mazeObstaclesTab(int[][] maze) {
		int dp[][] = new int[maze.length+1][maze[0].length+1];
		dp[0][1]=1;
		 for(int i=1; i<=maze.length ;i++){
		      for(int j=1; j<=maze[i-1].length; j++){
		          if(maze[i-1][j-1] != -1) {
		        	  int up = dp[i-1][j];
		        	  int left = dp[i][j-1];
		        	  dp[i][j] = up+left;
		          }
		      }
		      
		  }
		 return dp[maze.length][maze[0].length];
	}
//Space optimization
	 public int mazeObstaclesSpace(int n, int m,int[][] maze){

		    int prev[]=new int[n];
		    for(int i=0; i<n; i++){
		        int temp[]=new int[m];
		        for(int j=0; j<m; j++){
		            if(i>0 && j>0 && maze[i][j]==-1){
		                temp[j]=0;
		                continue;
		            }
		            if(i==0 && j==0){
		                temp[j]=1;
		                continue;
		            }
		            
		            int up=0;
		            int left =0;
		            
		            if(i>0)
		                up = prev[j];
		            if(j>0)
		                left = temp[j-1];
		                
		            temp[j] = up + left;
		        }
		        prev = temp;
		    }
		    
		    return prev[n-1];

		    
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMazeObstracles obj=new IMazeObstracles();
		int[][] maze = { { 0, 0, 0 }, { 0, -1, 0 }, { 0, 0, 0 } };

		int n = maze.length;
		int m = maze.length;
		int dp[][] = new int[n][m];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		System.out.println(obj.mazeObstaclesUtil(n-1,m-1,maze));
		System.out.println(obj.mazeObstaclesMemo(n-1,m-1,maze,dp));
		System.out.println(obj.mazeObstaclesTab(maze));
		System.out.println(obj.mazeObstaclesSpace(n, m, maze));
	}

}
