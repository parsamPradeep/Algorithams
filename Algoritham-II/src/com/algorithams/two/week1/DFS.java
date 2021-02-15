package com.algorithams.two.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author pradeep
 *
 */
public class DFS {
	private boolean marked[];
	private int count;

	/**
	 * 
	 * @author pradeep Inner Graph class
	 *
	 */
	private class Graph {
		private final int V;
		private int E;
		private List<Integer> graph[];

		/**
		 * 
		 * @param v constructor to initialise graph[]
		 */
		Graph(int v) {
			V = v;
			for (int i = 0; i < V; i++)
				graph[i] = new ArrayList<Integer>();
		}

		/**
		 * 
		 * @return number of vertices
		 */
		public int V() {
			return V;
		}

		/**
		 * 
		 * @return number of edges
		 */
		public int E() {
			return E;
		}

		/**
		 * 
		 * @param void it validate given vertex and throw error if its not in range 0-V
		 */
		public void validateVertex(int v) {
			if (v < 0 || v >= V)
				throw new IllegalArgumentException("vertex v is not i range 0-" + V);
		}

		/**
		 * 
		 * @param i
		 * @param j add the new edge to a graph
		 */
		public void addEdge(int i, int j) {
			validateVertex(i);
			validateVertex(j);
			graph[i].add(j);
			graph[j].add(i);
			E++;
		}

		/*
		 * it gives all adjacent vertices of given node
		 */
		public Iterable<Integer> adj(int v) {
			return graph[v];
		}
	}

	/**
	 * 
	 * @param g
	 * @param s constructor to initialise the array
	 */
	DFS(Graph g, int s) {
		marked = new boolean[g.V()];
		g.validateVertex(s);
		dfs(g, s);
	}

	/**
	 * 
	 * @param g
	 * @param s method to find dfs
	 */
	public void dfs(Graph g, int s) {
		count++;
		marked[s] = true;
		for (int i : g.adj(s)) {
			if (!marked[s]) {
				dfs(g, i);
			}
		}
	}

}
