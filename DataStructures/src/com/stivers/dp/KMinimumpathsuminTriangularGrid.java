package com.stivers.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMinimumpathsuminTriangularGrid {
//Recursion
	public int minimumTotalRecur(List<List<Integer>> triangle) {
		return helper1(0, 0, triangle);
	}

	public int helper1(int i, int j, List<List<Integer>> triangle) {
		if (i == triangle.size() - 1)
			return triangle.get(i).get(j);
		int down = triangle.get(i).get(j) + helper1(i + 1, j, triangle);
		int diag = triangle.get(i).get(j) + helper1(i + 1, j + 1, triangle);
		return Math.min(down, diag);
	}

//Memoization
	public int minimumTotalMemo(List<List<Integer>> triangle) {
		int dp[][] = new int[triangle.size()][triangle.size()];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return helper2(0, 0, triangle, dp);
	}

	public int helper2(int i, int j, List<List<Integer>> triangle, int[][] dp) {
		if (i == triangle.size() - 1)
			return triangle.get(i).get(j);
		if (dp[i][j] != -1)
			return dp[i][j];
		int down = triangle.get(i).get(j) + helper2(i + 1, j, triangle, dp);
		int diag = triangle.get(i).get(j) + helper2(i + 1, j + 1, triangle, dp);
		return dp[i][j] = Math.min(down, diag);
	}

//Tabulation
	public int minimumTotaltab(List<List<Integer>> triangle) {
		int dp[][] = new int[triangle.size()][triangle.size()];
		for (int j = 0; j < triangle.size(); j++) {
			dp[triangle.size() - 1][j] = triangle.get(triangle.size() - 1).get(j);
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {

				int down = triangle.get(i).get(j) + dp[i + 1][j];
				int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

				dp[i][j] = Math.min(down, diagonal);
			}
		}

		return dp[0][0];
	}

//Space optimization
	public int minimumTotalSpace(List<List<Integer>> triangle) {
		int temp[] = new int[triangle.size()];
		int curr[] = new int[triangle.size()];
		for (int j = 0; j < triangle.size(); j++) {
			temp[j] = triangle.get(triangle.size() - 1).get(j);
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {

				int down = triangle.get(i).get(j) + temp[j];
				int diagonal = triangle.get(i).get(j) + temp[j + 1];

				curr[j] = Math.min(down, diagonal);
			}
			temp=curr;
		}

		return temp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		List<List<Integer>> listOfLists = new ArrayList<>();

		for (int[] row : arr) {
			List<Integer> list = new ArrayList<>(Arrays.asList(Arrays.stream(row).boxed().toArray(Integer[]::new)));
			listOfLists.add(list);
		}
		KMinimumpathsuminTriangularGrid obj = new KMinimumpathsuminTriangularGrid();
		obj.minimumTotaltab(listOfLists);
	}

}
