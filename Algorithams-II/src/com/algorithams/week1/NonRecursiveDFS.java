package com.algorithams.week1;

import java.util.Stack;

public class NonRecursiveDFS {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path

	NonRecursiveDFS(Graph G, int s) {
		marked = new boolean[G.V()];
		G.validateVertex(s);
		dfs(G, s);
	}

	private void dfs(Graph G, int s) {
		Stack<Integer> stack = new Stack<Integer>();
		marked[s] = true;
		stack.push(s);
		while (!stack.isEmpty()) {
			int v = stack.pop();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					stack.push(w);
				}
			}

		}
	}

}
