package com.leetcode.problems.easy.array;
/*
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
public class RotateImage {
	 public static void rotate(int[][] matrix) {
	        for(int i=0;i<matrix.length;i++){
	            int r=matrix[i].length-1;
	            for(int j=0;j<matrix[i].length/2;j++){
	               int temp=matrix[i][r];
	                matrix[i][r]=matrix[i][j];
	                matrix[i][j]=temp;
	                r--;
	          }
	        }
	        
	        for(int i=0;i<matrix.length;i++){
	            int col=matrix[i].length-i-1;
	            int row=matrix.length-1;
	            for(int j=0;j<matrix[0].length-i-1;j++){
	                int temp=matrix[row][col];
	                matrix[row][col]=matrix[i][j];
	                matrix[i][j]=temp;
	                row--;
	            }
	        }

	    }
	public static void main(String[] args) {
		int matrix[][]={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		rotate(matrix);
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

	}

}
