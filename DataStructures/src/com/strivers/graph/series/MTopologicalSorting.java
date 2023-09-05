package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MTopologicalSorting {
	public int[] topologicalSort(int graph[][]) {
		List<List<Integer>> adj = new ArrayList<>();
		boolean vis[] = new boolean[graph.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < graph.length; i++)
			adj.add(new ArrayList<Integer>());
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++)
				adj.get(i).add(graph[i][j]);
		}
		for (int i = 0; i < graph.length; i++)
			if (!vis[i])
				dfs(i, adj, vis, stack);
		int arr[] = new int[graph.length];
		int i = 0;
		while (!stack.isEmpty())
			arr[i++] = stack.pop();
		return arr;
	}

	public void dfs(int s, List<List<Integer>> adj, boolean vis[], Stack<Integer> stack) {
		vis[s] = true;
		for (int adjc : adj.get(s))
			if (!vis[adjc])
				dfs(adjc, adj, vis, stack);
		stack.push(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { {}, {}, { 3 }, { 1 }, { 0, 1 }, { 0, 2 } };
		MTopologicalSorting obj = new MTopologicalSorting();
		int res[] = obj.topologicalSort(arr);
		for (int i : res)
			System.out.print(i + ", ");// Ans [5,4,2,3,1,0]or[4,5,2,3,1,0]

	}

}
