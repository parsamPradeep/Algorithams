package com.leetcode.problems.easy.array;

public class SpiralMatrixII {
	 public static int[][] generateMatrix(int n) {
	        int res[][]=new int[n][n];
	        int r1=0, r2=res.length-1;
	        int c1=0,c2=res[0].length-1;
	        int counter=1;
	        while(r1<=r2 && c1<=c2){
	            for(int c=c1;c<=c2;c++)
	                res[r1][c]=counter++;
	            
	            for(int r=r1+1;r<=r2;r++)
	                res[r][c2]=counter++;
	            if(r1<r2 && c1<c2){
	                for(int c=c2-1;c>c1;c--)
	                    res[r2][c]=counter++;
	                for(int r=r2;r>r1;r--)
	                    res[r][c1]=counter++;
	            }
	            r1++;
	            r2--;
	            c1++;
	            c2--;
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
