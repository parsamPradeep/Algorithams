package com.strivers.graph.series;

import java.util.LinkedList;
import java.util.Queue;

public class CNumberofProvinces {
//Approach -1 DFS
	public static int findCircleNum(int[][] M) {
		int N = M.length;
		boolean[] visited = new boolean[N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				count++;
				dfs(M, i, visited);
			}
		}
		return count;
	}

	private static void dfs(int[][] M, int i, boolean[] visited) {
		for (int j = 0; j < M[i].length; j++) {
			if (!visited[j] && M[i][j] != 0) {
				visited[j] = true;
				dfs(M, j, visited);
			}
		}
	}

// Approach -2 BFS
	public int findCircleNum2(int[][] pro) {

		boolean visited[] = new boolean[pro.length + 1];
		int count = 0;
		for (int i = 0; i < pro.length; ++i) {
			if (visited[i] == false) {
				count++;
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				visited[i] = true;
				while (!q.isEmpty()) {
					Integer vertex = q.poll();
					for (int j = 0; j < pro[0].length; ++j) {
						if (!visited[j] && pro[vertex][j] == 1) {
							q.add(j);
							visited[j] = true;
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(arr));
	}

}
