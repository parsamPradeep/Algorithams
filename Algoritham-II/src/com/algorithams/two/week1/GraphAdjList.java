package com.algorithams.two.week1;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjList {

	private final int V;
	private int E;
	private List<Integer>[] adj;
	
	
	/**
	 * 
	 * @param v
	 * it accept the vertex and in initialise the adj array of list
	 */
	public GraphAdjList(int v) {
		V = v;
		adj=new ArrayList[V];
		for(int i=0;i<V;i++)
			adj[i]=new ArrayList<Integer>();
	}
	
	
	/**
	 * 
	 * @return
	 * it return the No of Vertices
	 */
	public int V() {
		return V;
	}
	
	/**
	 * 
	 * @return
	 * it returns number of edges
	 */
	public int E() {
		return E;
	}
	
	/**
	 * 
	 * @param v
	 * validate the vertex, range 0-(V-1)
	 * throws Exception if vertex is not in range
	 */
	public void validateVertex(int v) {
		if(v<0||v>=V)
			throw new IllegalArgumentException("vertex "+v+" is not between 0 and "+(V-1));
	}
	
	/**
	 * 
	 * @param s
	 * @param d
	 * 
	 * add the edge from source vertex to destination vertex 
	 */
	public void addEdge(int s, int d) {
		validateVertex(s);
		validateVertex(d);
		E++;
		adj[s].add(d);
		adj[d].add(s);
	}

	/**
	 * 
	 * @param v
	 * @return Iterable<Integer>
	 * it return the list of all vertices attached to vertex
	 */
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	/**
	 * return a degree of specified vertex
	 */
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	/**
	 * 
	 * @return the max degree of graph
	 */
	public int maxDegree() {
		int max=0;
		for(int i=0;i<V;i++)
			if(adj[i].size()>max)
				max=adj[i].size();
		return max;
	}

	/**
	 * 
	 * @return average degree of graph 
	 */
	public int averageDegree() {
		return (2*E())/V();
	}
	
	
	/**
	 * 
	 * @return the number of self loop
	 */
	public int numberOfSelfLoop() {
		int count=0;
		for(int v=0;v<V;v++)
			for(int w:adj(v))
				if(v==w)
					count++;
		return count/2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjList gr=new GraphAdjList(4);
		gr.adj[1].add(1);
		gr.adj[1].add(2);
		gr.adj[1].add(3);
		gr.adj[2].add(1);
		gr.adj[2].add(3);
		gr.adj[2].add(2);
		
		for(int w:gr.adj(1))
			System.out.println(w);
			

	}

}
