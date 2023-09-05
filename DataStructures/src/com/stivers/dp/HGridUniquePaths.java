 
package com.stivers.dp;

import java.util.Arrays;

public class HGridUniquePaths {
//Recursion
	//Recursion -1
	public int countWaysRecr1(int i, int j) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;

		int up = countWaysRecr1(i - 1, j);
		int left = countWaysRecr1(i, j - 1);

		return up + left;

	}

//Memoization
	public int countWaysMemo(int i, int j, int[][] dp) {
		  if(i==0 && j == 0)
			    return 1;
			  if(i<0 || j<0)
			    return 0;
			  if(dp[i][j]!=-1) return dp[i][j];
			    
			  int up = countWaysMemo(i-1,j,dp);
			  int left = countWaysMemo(i,j-1,dp);
			  
			  return dp[i][j] = up+left;
			  
			}
//Tabulation
	public int countWaysTab(int m, int n) {
		 int dp[][]=new int[m+1][n+1];
		 dp[0][1]=1;
		 for(int i=1; i<=m ;i++){
		      for(int j=1; j<=n; j++){
		            
		          dp[i][j] = dp[i-1][j]+dp[i][j-1];
		      }
		  }
		 return dp[m][n];
	}
//Space optimization
	public int countWaysSpace(int m, int n){
	    int prev[]=new int[n];
	    for(int i=0; i<m; i++){
	        int temp[]=new int[n];
	        for(int j=0; j<n; j++){
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
		 int m=3;
		  int n=2;
		  HGridUniquePaths obj=new HGridUniquePaths();
		  int dp[][]=new int[m][n];
		    for (int[] row : dp)
		        Arrays.fill(row, -1);
		  System.out.println(obj.countWaysRecr1(m-1,n-1));
		  System.out.println(obj.countWaysMemo(m-1,n-1, dp));
		  System.out.println(obj.countWaysTab(m,n));
		  System.out.println(obj.countWaysSpace(m,n));
	}

}
