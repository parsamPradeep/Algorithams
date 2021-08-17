package com.algorithams.week1;

import java.util.LinkedList;

public class BFS {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked; // marked[v] = is there an s-v path
	private int[] edgeTo; // edgeTo[v] = previous edge on shortest s-v path
	private int[] distTo; // distTo[v] = number of edges shortest s-v path

	/**
	 * Computes the shortest path between the source vertex {@code s} and every
	 * other vertex in the graph {@code G}.
	 * 
	 * @param G the graph
	 * @param s the source vertex
	 * @throws IllegalArgumentException unless {@code 0 <= s < V}
	 */
	public BFS(Graph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		validateVertex(s);
		bfs(G, s);
	}

	// breadth-first search from a single source
	private void bfs(Graph G, int s) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		distTo[s] = 0;
		marked[s] = true;
		q.add(s);

		while (!q.isEmpty()) {
			int v = q.poll();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.add(w);
				}
			}
		}
	}

	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}
}
