package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LFindEventualSafeState {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<List<Integer>> adj = new ArrayList<>();
		List<Integer> safeState = new ArrayList<>();
		boolean vis[] = new boolean[graph.length];
		boolean pathVis[] = new boolean[graph.length];
		boolean check[] = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++)
			adj.add(new ArrayList<Integer>());
		for (int i = 0; i < graph.length; i++) {
			if (graph[i].length == 0)
				safeState.add(i);
			for (int j = 0; j < graph[i].length; j++)
				adj.get(i).add(graph[i][j]);
		}
		for (int i = 0; i < graph.length; i++)
			if (adj.get(i).size() > 0 && !vis[i])
				dfs(i, adj, vis, pathVis, check);
		for (int i = 0; i < graph.length; i++)
			if (adj.get(i).size() > 0 && check[i])
				safeState.add(i);
		Collections.sort(safeState);
		return safeState;
	}

	public boolean dfs(int source, List<List<Integer>> adj, boolean vis[], boolean pathVis[], boolean check[]) {
		vis[source] = true;
		pathVis[source] = true;
		check[source] = false;
		for (int adjc : adj.get(source)) {
			if (!vis[adjc] && dfs(adjc, adj, vis, pathVis, check)) {
				check[source] = false;
				return true;
			} else if (pathVis[adjc]) {
				check[source] = false;
				return true;
			}
		}
		pathVis[source] = false;
		check[source] = true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]={{1,2},{2,3},{5},{0},{5},{},{}};
		LFindEventualSafeState obj=new LFindEventualSafeState();
		System.out.println(obj.eventualSafeNodes(arr)); //Ans [2,4,5,6]

	}

}
