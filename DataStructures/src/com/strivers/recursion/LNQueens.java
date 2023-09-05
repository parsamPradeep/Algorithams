package com.strivers.recursion;

import java.util.ArrayList;
import java.util.List;

public class LNQueens {
	public List<List<String>> solveNQueens(int n) {
		String board[][] = new String[n][n];
		List<List<String>> ans = new ArrayList<>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = ".";
		solve(board, ans, 0);
		return ans;
	}

	public void solve(String board[][], List<List<String>> ans, int col) {
		if (col == board.length) {
			List<String> list = new ArrayList<>();

			for (int i = 0; i < board.length; i++) {
				String str = "";
				for (int j = 0; j < board[i].length; j++)
					str += board[i][j];
				list.add(str);
			}

			ans.add(list);
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (isSafe(i, col, board)) {
				board[i][col] = "Q";
				solve(board, ans, col + 1);
				board[i][col] = ".";
			}
		}
	}

	public boolean isSafe(int row, int col, String board[][]) {
		int dupRow = row;
		int dupCol = col;
		while (row >= 0 && col >= 0) {
			if (board[row][col] == "Q")
				return false;
			row--;
			col--;
		}
		row = dupRow;
		col = dupCol;
		while (col >= 0) {
			if (board[row][col] == "Q")
				return false;
			col--;
		}
		row = dupRow;
		col = dupCol;
		while (row < board.length && col >= 0) {
			if (board[row][col] == "Q")
				return false;
			row++;
			col--;
		}
		return true;
	}

//--------------------------------------------------------------------------------------------------------------------
	/* Approach - 2 */
//--------------------------------------------------------------------------------------------------------------------

	public List<List<String>> solveNQueens2(int n) {
		String board[][] = new String[n][n];
		List<List<String>> ans = new ArrayList<>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = ".";
		int leftRows[] = new int[n];
		int lowerDiag[] = new int[2 * n - 1];
		int upperDiag[] = new int[2 * n - 1];
		solve(board, ans, n, leftRows, lowerDiag, upperDiag, 0);
		return ans;
	}

	public void solve(String board[][], List<List<String>> ans, int n, int leftRows[], int lowerDiag[], int upperDiag[],
			int col) {
		if (col == n) {
			List<String> list = new ArrayList<>();

			for (int i = 0; i < board.length; i++) {
				String str = "";
				for (int j = 0; j < board[i].length; j++)
					str += board[i][j];
				list.add(str);
			}

			ans.add(list);
			return;
		}
		for (int row = 0; row < board.length; row++) {
			if (leftRows[row] == 0 && lowerDiag[row + col] == 0 && upperDiag[n - 1 + col - row] == 0) {
				leftRows[row] = 1;
				lowerDiag[row + col] = 1;
				upperDiag[n - 1 + col - row] = 1;
				board[row][col] = "Q";
				solve(board, ans, n, leftRows, lowerDiag, upperDiag, col + 1);
				board[row][col] = ".";
				leftRows[row] = 0;
				lowerDiag[row + col] = 0;
				upperDiag[n - 1 + col - row] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LNQueens obj = new LNQueens();
		System.out.println(obj.solveNQueens(4));
		System.out.println(obj.solveNQueens2(4));
	}

}
