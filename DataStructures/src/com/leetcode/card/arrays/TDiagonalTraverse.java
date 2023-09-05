 package com.leetcode.card.arrays;
/*
Given a matrix of M x N elements (M rows, N columns), 
return all elements of the matrix in diagonal order as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]
 */
public class TDiagonalTraverse {
	public static int [] diaTraverse(int matrix[][]) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		
		int r=0,c=0,index=0;
		int resArry[]=new int[rows*cols];
		
		for(int k=0;k<resArry.length;k++) {
			resArry[index++]=matrix[r][c];
			if((r+c)%2==0) {
				if(c==cols-1)
					r++;
				else if(r==0)
					c++;
				else {
					r--;
					c++;
				}
			}else {
				if(r==rows-1)
					c++;
				else if(c==0)
					r++;
				else {
					c--;
					r++;
				}
			}
		}
		return resArry;
	}
	public static int [] diaTraverse1(int matrix[][]) {
		int M=matrix.length;
		int N=matrix[0].length;
		int res[]=new int[M*N];
		int inx=0;
		for(int k=0;k<M;k++) {
			int i=k;
			int j=0;
			while(i>=0) {
				res[inx]=matrix[i][j];
				i=i-1;
				j=j+1;
				inx++;
			}
		}
		for(int k=1;k<N;k++) {
			int i=M-1;
			int j=k;
			while(j<N) {
				res[inx]=matrix[i][j];
				i=i-1;
				j=j+1;
				inx++;
			}
		}
		return res;
		 
	}
 	public static void main(String[] args) {
		int arr[][]={
				 { 1, 2, 3 },
				 { 4, 5, 6 },
				 { 7, 8, 9 }
				};
		int res[]=diaTraverse1(arr);
		for(int i:res)
			System.out.println(i);
	}

}
