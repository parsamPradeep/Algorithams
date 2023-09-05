package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KCycleDetectionInDirectedG {
	// Approach - 1 DFS
	public boolean checkCycleDFS(int src, int parent, List<List<Integer>> adj, boolean vis[], boolean pathVis[]) {
		vis[src] = true;
		pathVis[src] = true;
		for (int adjc : adj.get(src)) {
			if (!vis[adjc])
				if (checkCycleDFS(adjc, src, adj, vis, pathVis))
					return true;
				else if (pathVis[adjc])
					return true;
		}
		pathVis[src] = false;
		return false;
	}

	public boolean isCycle(int graph[][]) {
		int n = graph.length;

		List<List<Integer>> adj = new ArrayList<>();
		boolean vis[] = new boolean[n];
		boolean pathVis[] = new boolean[n];

		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		for (int arr[] : graph) {
			adj.get(arr[0]).add(arr[1]);
			adj.get(arr[1]).add(arr[0]);
		}

		for (int i = 0; i < n; i++) {
			if (!vis[i])
				if (checkCycleDFS(i, n, adj, vis, pathVis))
					return true;
		}

		return false;
	}

	// Approach - 2 toposort
	public int bfs(List<List<Integer>> adj) {
		int indegree[] = new int[adj.size()];
		for (int i = 0; i < adj.size(); i++)
			for (int adjc : adj.get(i))
				indegree[adjc]++;

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < adj.size(); i++)
			if (indegree[i] == 0)
				q.add(i);

		int i = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			i++;
			for (int adjc : adj.get(node)) {
				indegree[adjc]--;
				if (indegree[adjc] == 0)
					q.add(adjc);
			}
		}
		return i;
	}

	public boolean isCycletopoSort(int[][] graph) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < graph.length; i++)
			adj.add(new ArrayList<Integer>());
		for (int i = 0; i < graph.length; i++)
			for (int j = 0; j < graph[i].length; j++)
				adj.get(i).add(graph[i][j]);
		return bfs(adj) == adj.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		KCycleDetectionInDirectedG obj = new KCycleDetectionInDirectedG();
		System.out.println(obj.isCycle(arr));
		System.out.println(obj.isCycletopoSort(arr));

	}

}
