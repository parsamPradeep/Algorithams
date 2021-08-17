package com.algorithams.week1;

public class DFS {
	private boolean marked[];	//arry to track visited vertex
	private int count;		//count number of vertices connected to s
	
	
	/**
	 * initialise the tacking arry 
	 * @param G
	 * @param s
	 */
	DFS(Graph G, int s){
		marked=new boolean[G.V()];
		G.validateVertex(s);
		dfs(G,s);
	}
	
	/*
	 * depth-first-search from s with recursion
	 */
	public void dfs(Graph G, int s) {
		marked[s]=true;
		count++;
		for(int w:G.adj(s)) {
			if(!marked[w]) {
				marked[w]=true;
				dfs(G,w);
			}
		}
	}

}
