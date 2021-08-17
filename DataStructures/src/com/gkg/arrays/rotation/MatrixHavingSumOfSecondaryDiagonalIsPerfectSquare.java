package com.gkg.arrays.rotation;
/*
 Input: N = 3
Output:
1 2 3
2 3 1
3 2 1
Explanation:
The sum of secondary diagonal = 3 + 3 + 3 = 9(= 32).

Input: N = 7
Output:
1 2 3 4 5 6 7
2 3 4 5 6 7 1
3 4 5 6 7 1 2
4 5 6 7 1 2 3
5 6 7 1 2 3 4
6 7 1 2 3 4 5
7 1 2 3 4 5 6
Explanation:
The sum of secondary diagonal = 7 + 7 + 7 + 7 + 7 + 7 + 7 = 49(= 72).
 */
public class MatrixHavingSumOfSecondaryDiagonalIsPerfectSquare {
	public static void perfectSquare(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[(i+j)%arr.length]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		int len=5;
		int arr[]=new int[len];
		for(int i=0;i<len;i++)
			arr[i]=i+1;
		perfectSquare(arr);

	}

}
