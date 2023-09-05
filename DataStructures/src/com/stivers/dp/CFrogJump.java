package com.stivers.dp;

import java.util.Arrays;

public class CFrogJump {
//Recursion
	public int jump(int inx, int arr[]) {
		if(inx<=0) return 0;
		
		int jump1=jump(inx-1, arr)+Math.abs(arr[inx]-arr[inx-1]);
		int jump2=Integer.MAX_VALUE;
		if(inx>1)
			jump2=jump(inx-2, arr)+Math.abs(arr[inx]-arr[inx-2]);
		return Math.min(jump1, jump2);
	}
	
// Memoization
		public int jumpMemo(int inx, int arr[], int dp[]) {
			if(inx<=0) return 0;
			if(dp[inx]!=-1) return dp[inx];
			int jump1=jumpMemo(inx-1, arr, dp)+Math.abs(arr[inx]-arr[inx-1]);
			int jump2=Integer.MAX_VALUE;
			if(inx>1)
				jump2=jumpMemo(inx-2, arr, dp)+Math.abs(arr[inx]-arr[inx-2]);
			return dp[inx]=Math.min(jump1, jump2);
		}

//Tabulation
		public  int jumpTabulation(int arr[]) {
			int dp[]=new int[arr.length];
			dp[1]=Math.abs(arr[1]-arr[0]);
			for(int i=2;i<arr.length;i++) {
				int fs=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
				
				int ss=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
				dp[i]=Math.min(fs, ss);
			}
			return dp[arr.length-1];
		}

//Memory Optimization
		public  int jumpMemoOptim(int n, int arr[]) {
			int prev=0;
			int prev1=0;
			for(int i=1;i<arr.length;i++) {
				int fs=prev+Math.abs(arr[i]-arr[i-1]);
				int ss=Integer.MAX_VALUE;
				if(i>1) ss=prev1+Math.abs(arr[i]-arr[i-2]);
				int curri=Math.min(fs, ss);
				prev1=prev;
				prev=curri;
			}
			return prev;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height[]={30,10,60 , 10 , 60 , 50};
		int n=height.length-1;
		int dp[]=new int[height.length+1];
		Arrays.fill(dp, -1);
		CFrogJump obj=new CFrogJump();
		System.out.println(obj.jump(n, height));
		System.out.println(obj.jumpMemo(n, height, dp));
		System.out.println(obj.jumpTabulation(height));
	}

}
