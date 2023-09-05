package com.stivers.dp;

import java.util.Arrays;

public class DFrogJumpwithkDistances {
//Recursion
	// Recursion - 1
	public int frogJumpKRec(int inx, int[] arr, int k) {
		if(inx==0) return 0;
		int mmSteps=Integer.MAX_VALUE;
		for(int j=1;j<=k;j++) {
			if(inx-j>=0) {
				int jump=Math.abs(arr[inx]-arr[inx-j])+frogJumpKRec(inx-j, arr, k);
				mmSteps=Math.min(jump, mmSteps);
			}
		}
		return mmSteps;
	}
	//Recursion - 2
	public int frogJumpKRec2(int inx, int[] arr, int k) {
		if(inx==arr.length-1) return 0;
		int mmSteps=Integer.MAX_VALUE;
		for(int j=1;j<=k;j++) {
			if(inx+j<arr.length) {
				int jump=Math.abs(arr[inx]-arr[inx+j])+frogJumpKRec2(inx+j, arr, k);
				mmSteps=Math.min(jump, mmSteps);
			}
		}
		return mmSteps;
	}

//Memoization
	//Memoization - 1
	public int frogJumpKMemo(int inx, int[] arr, int k, int dp[]) {
		if(inx==0) return 0;
		if(dp[inx]!=-1) return dp[inx];
		int mmSteps=Integer.MAX_VALUE;
		for(int j=1;j<=k;j++) {
			if(inx-j>=0) {
				int jump=Math.abs(arr[inx]-arr[inx-j])+frogJumpKMemo(inx-j, arr, k, dp);
				mmSteps=Math.min(jump, mmSteps);
			}
		}
		return dp[inx]=mmSteps;
	}
	//Memoization - 2
	public int frogJumpKMemo2(int inx, int[] arr, int k, int dp[]) {
		if(inx==arr.length-1) return 0;
		if(dp[inx]!=-1) return dp[inx];
		int mmSteps=Integer.MAX_VALUE;
		for(int j=1;j<=k;j++) {
			if(inx+j<arr.length) {
				int jump=Math.abs(arr[inx]-arr[inx+j])+frogJumpKMemo2(inx+j, arr, k, dp);
				mmSteps=Math.min(jump, mmSteps);
			}
		}
		return dp[inx]=mmSteps;
	}

// Tabulation
	public int frontJumpKTab( int arr[], int k) {
		int dp[]=new int[arr.length];
		//Arrays.fill(dp, -1);
		dp[0]=0;
		dp[1]=Math.abs(arr[0]- arr[1]);
		for(int i=2;i<arr.length;i++) {
			int mmSteps=Integer.MAX_VALUE;
			for(int j=1;j<=k;j++) {
				if(i-j>=0) {
					int jump=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
					mmSteps=Math.min(mmSteps, jump);
				}
			}
			dp[i]=mmSteps;
		}
		return dp[arr.length-1];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height[]={30,10,60 , 10 , 60 , 50};
		DFrogJumpwithkDistances obj=new DFrogJumpwithkDistances();
		int dp[]=new int[height.length];
		Arrays.fill(dp, -1);
		System.out.println(obj.frogJumpKRec(height.length-1, height, 2));
		System.out.println(obj.frogJumpKRec2(0, height, 2));
		System.out.println(obj.frogJumpKMemo(height.length-1, height, 2, dp));
		System.out.println(obj.frogJumpKMemo2(0, height, 2, dp));
		System.out.println(obj.frontJumpKTab(height, 2));
	}

}
