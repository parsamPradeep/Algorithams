package com.algorithams.week1;

public class AdjacentMatixGraph {
	
	private final int V;
	private int E;
	private boolean[][] adj;
	
	public AdjacentMatixGraph(int v) {
		V=v;
		adj=new boolean[v][v];
		E=0;
	}
	
    // number of vertices and edges
    public int V() { return V; }
    public int E() { return E; }


    // add undirected edge v-w
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }

    // does the graph contain the edge v-w?
    public boolean contains(int v, int w) {
        return adj[v][w];
    }

}
