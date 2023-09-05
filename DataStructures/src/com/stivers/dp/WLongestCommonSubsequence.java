package com.stivers.dp;

import java.util.Arrays;

public class WLongestCommonSubsequence {
//Recursion
	public static int longestCommonSubsequenceRecur(String text1, String text2) {
	       return helper1(text1.length()-1, text2.length()-1, text1, text2);
	    }
	    public static int helper1(int pt1, int pt2, String s1, String s2){
	        if(pt1<0 || pt2<0) return 0;

	        if(s1.charAt(pt1)==s2.charAt(pt2)) 
	            return 1+helper1(pt1-1, pt2-1, s1,s2);
	        else 
	            return 0+Math.max(helper1(pt1-1,pt2,s1,s2), helper1(pt1,pt2-1,s1,s2));
	    }
//Memoization
	    public int longestCommonSubsequenceMemo(String text1, String text2) {
	        int dp[][]=new int[text1.length()][text2.length()];
	        for(int arr[]:dp) Arrays.fill(arr, -1);
	       return helper2(text1.length()-1, text2.length()-1, text1, text2, dp);
	    }
	    public int helper2(int pt1, int pt2, String s1, String s2, int dp[][]){
	        if(pt1<0 || pt2<0) return 0;
	        if(dp[pt1][pt2]!=-1) return dp[pt1][pt2];
	        if(s1.charAt(pt1)==s2.charAt(pt2)) 
	            return dp[pt1][pt2]=1+helper2(pt1-1, pt2-1, s1,s2, dp);
	        else 
	            return dp[pt1][pt2]=0+Math.max(helper2(pt1-1,pt2,s1,s2,dp), helper2(pt1,pt2-1,s1,s2,dp));
	    }
//Tabulation
	    public int longestCommonSubsequencetabu(String text1, String text2) {
	        int arr[][]=new int[text1.length()+1][text2.length()+1];
	        int max=0;
	        for(int i=1;i<arr.length;i++){
	            for(int j=1;j<arr[i].length;j++){
	                if(text1.charAt(i-1)==text2.charAt(j-1)){
	                    arr[i][j]=arr[i-1][j-1]+1;
	                }else {
	                    arr[i][j]=Math.max(arr[i][j-1], arr[i-1][j]);
	                }
	                if(arr[i][j]>max)
	                    max=arr[i][j];
	            }
	        }
	        return max;
	       
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String s1= "acd";
		  String s2= "ced";
		  WLongestCommonSubsequence obj=new WLongestCommonSubsequence();
		  System.out.println(obj.longestCommonSubsequencetabu(s1, s2));
	}

}
