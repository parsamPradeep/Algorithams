package com.algorithams.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author pradeep
 *
 */
public class Graph {
	private final int V;		//to store number of vertices
	private int E;				// to store number of edges
	private List<Integer> adj[];
	
	
	/**
	 * accept the input and initialise the adjacent list
	 * @param v
	 */
	Graph(int v){
		V=v;
		adj=new List[V];
		for(int i=0;i<V;i++)
			adj[i]=new ArrayList<Integer>();
	}
	
	/**
	 * return number of vertices
	 * @return
	 */
	public int V() {
		return V;
	}
	
	/**
	 * return number of edges
	 * @return
	 */
	public int E() {
		return E;
	}
	
	
	/**
	 * validate the given vertex throw error if given vertex not in range  
	 * @param v
	 */
	public void validateVertex(int v) {
		if(v<0||v>V)
			throw new IllegalArgumentException("given vertex is not in range 0-"+V);
	}
	
	/**
	 * add the edge from source s to destination d
	 * @param s
	 * @param d
	 */
	public void addEdge(int s,int d) {
		validateVertex(s);
		validateVertex(d);
		adj[s].add(d);
		adj[d].add(s);
	}
	
	
	/**
	 * return all adjacent vertices to given vertex
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v){
		validateVertex(v);
		return adj[v];
	}
	
	
	/**
	 * return number of edges to gives vertex
	 * @param v
	 * @return
	 */
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
}
