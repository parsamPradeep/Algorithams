package com.strivers.graph.series;

import java.util.LinkedList;
import java.util.Queue;

public class GSurroundedReagion {
// Approach - 1 DFS
	public boolean vis[][];

	public void solve1(char[][] board) {

		vis = new boolean[board.length][board[0].length];
		int r1 = 0, r2 = board.length - 1;
		int c1 = 0, c2 = board[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++)
				if (board[r1][c] == 'O' && !vis[r1][c])
					dfs(r1, c, board);
			for (int r = r1 + 1; r <= r2; r++)
				if (board[r][c2] == 'O' && !vis[r][c2])
					dfs(r, c2, board);
			if (r1 < r2 && c1 < c2) {
				for (int c = c2 - 1; c > c1; c--)
					if (board[r2][c] == 'O' && !vis[r2][c])
						dfs(r2, c, board);

				for (int r = r2; r > r1; r--) {
					if (board[r][c1] == 'O' && !vis[r][c1])
						dfs(r, c1, board);
				}
			}
			r1 = board.length;
			c1 = board[0].length;
		}
		for (int i = 0; i < vis.length; i++)
			for (int j = 0; j < vis[i].length; j++)
				if (!vis[i][j])
					board[i][j] = 'X';

	}

	public void dfs(int row, int col, char board[][]) {
		int n = board.length - 1;
		int m = board[0].length - 1;
		if (row < 0 || row > n || col < 0 || col > m || vis[row][col] || board[row][col] != 'O')
			return;
		vis[row][col] = true;
		dfs(row + 1, col, board);
		dfs(row - 1, col, board);
		dfs(row, col + 1, board);
		dfs(row, col - 1, board);

	}

	// Approach -2 BFS
	public void solve2(char[][] board) {
		boolean vis[][] = new boolean[board.length][board[0].length];

		int r1 = 0, r2 = board.length - 1;
		int c1 = 0, c2 = board[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++)
				if (board[r1][c] == 'O' && !vis[r1][c])
					bfs(r1, c, board, vis);
			for (int r = r1 + 1; r <= r2; r++)
				if (board[r][c2] == 'O' && !vis[r][c2])
					bfs(r, c2, board, vis);
			if (r1 < r2 && c1 < c2) {
				for (int c = c2 - 1; c > c1; c--)
					if (board[r2][c] == 'O' && !vis[r2][c])
						bfs(r2, c, board, vis);

				for (int r = r2; r > r1; r--) {
					if (board[r][c1] == 'O' && !vis[r][c1])
						bfs(r, c1, board, vis);
				}
			}
			r1 = board.length;
			c1 = board[0].length;
		}
		for (int i = 0; i < vis.length; i++)
			for (int j = 0; j < vis[i].length; j++)
				if (!vis[i][j])
					board[i][j] = 'X';

	}

	public void bfs(int row, int col, char board[][], boolean vis[][]) {
		int delRow[] = { -1, 0, 1, 0 };
		int delCol[] = { 0, -1, 0, 1 };
		int n = board.length;
		int m = board[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		vis[row][col] = true;
		while (!queue.isEmpty()) {
			int arr[] = queue.poll();
			int r = arr[0];
			int c = arr[1];
			for (int i = 0; i < 4; i++) {
				int newR = r + delRow[i];
				int newC = c + delCol[i];
				if (newR >= 0 && newR < n && newC >= 0 && newC < m && !vis[newR][newC] && board[newR][newC] == 'O') {
					vis[newR][newC] = true;
					queue.add(new int[] { newR, newC });
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[][]={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		GSurroundedReagion obj=new GSurroundedReagion();
		obj.solve1(arr);
		// Ans [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
		for(char a[]: arr)
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]+", ");

	}

}
