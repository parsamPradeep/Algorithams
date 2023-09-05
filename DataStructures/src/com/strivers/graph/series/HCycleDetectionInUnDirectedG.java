package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HCycleDetectionInUnDirectedG {
	// Approach - 1 BFS
	public boolean checkCycleBFS(int src, int V, List<List<Integer>> adj, boolean vis[]) {
		vis[src] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { src, -1 });
		while (!q.isEmpty()) {
			int arr[] = q.poll();
			int node = arr[0];
			int parent = arr[1];

			for (int adjc : adj.get(node)) {
				if (!vis[adjc]) {
					vis[adjc] = true;
					q.add(new int[] { adjc, node });
				} else if (adjc != parent)
					return true;
			}
		}
		return false;

	}

	// Approach - 2 DFS
	public boolean checkCycleDFS(int src, int parent, List<List<Integer>> adj, boolean vis[]) {
		vis[src] = true;
		for (int adjc : adj.get(src)) {
			if (!vis[adjc])
				checkCycleDFS(adjc, src, adj, vis);
			else if (adjc != parent)
				return true;
		}
		return false;
	}

	public boolean isCycle(int graph[][]) {
		int n = graph.length;

		List<List<Integer>> adj = new ArrayList<>();
		boolean vis[] = new boolean[n + 1];
		boolean vis2[] = new boolean[n + 1];

		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		for (int arr[] : graph) {
			adj.get(arr[0]).add(arr[1]);
			adj.get(arr[1]).add(arr[0]);
		}

		boolean dfsRsult = checkCycleDFS(1, -1, adj, vis2);
		System.out.println("From Recurssion " + dfsRsult);

		for (int i = 1; i < n; i++) {
			if (!vis[i])
				if (checkCycleBFS(i, n, adj, vis))
					return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HCycleDetectionInUnDirectedG obj = new HCycleDetectionInUnDirectedG();
		int graph[][] = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		System.out.println(obj.isCycle(graph)); // Ans true

	}

}
