package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NKhansAlgo {
// BFS version of topological sort
	public int[] bfs(List<List<Integer>> adj) {
		int indegree[] = new int[adj.size()];
		for (int i = 0; i < adj.size(); i++)
			for (int adjc : adj.get(i))
				indegree[adjc]++;

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < adj.size(); i++)
			if (indegree[i] == 0)
				q.add(i);
		int topo[] = new int[adj.size()];
		int i = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			topo[i++] = node;
			for (int adjc : adj.get(node)) {
				indegree[adjc]--;
				if (indegree[adjc] == 0)
					q.add(adjc);
			}
		}
		return topo;
	}

	public int[] topoSort(int[][] graph) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < graph.length; i++)
			adj.add(new ArrayList<Integer>());
		for (int i = 0; i < graph.length; i++)
			for (int j = 0; j < graph[i].length; j++)
				adj.get(i).add(graph[i][j]);
		return bfs(adj);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { {}, {}, { 3 }, { 1 }, { 0, 1 }, { 0, 2 } };
		NKhansAlgo obj = new NKhansAlgo();
		int res[] = obj.topoSort(arr);
		for (int i : res)
			System.out.print(i + ", ");// Ans [5,4,2,3,1,0]or[4,5,2,3,1,0]or[4, 5, 0, 2, 3, 1]

	}

}
