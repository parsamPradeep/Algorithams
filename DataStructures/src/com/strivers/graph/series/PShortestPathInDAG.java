package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PShortestPathInDAG {
	public class Pairs{
		int node;
		int weight;
		Pairs(int node, int weight){
			this.node=node;
			this.weight=weight;
		}
	}
	public void topoSort(int node, boolean vis[], Stack<Integer> st, List<List<Pairs>> adj) {
		vis[node]=true;
		for(int i=0;i<adj.get(node).size();i++) {
			int v=adj.get(node).get(i).node;
			if(!vis[v]) {
				topoSort(v, vis, st, adj);
			}
		}
		st.push(node);
	}
	public int[] shortestPath(int grid[][]) {
		List<List<Pairs>> adj=new ArrayList<>();
		for(int i=0;i<grid.length;i++) adj.add(new ArrayList<>());
		for(int i=0; i< grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				int u=grid[i][0];
				int v=grid[i][1];
				int w=grid[i][2];
				adj.get(u).add(new Pairs(v, w));
			}
		}
		
		Stack<Integer> st=new Stack<>();
		boolean vis[]=new boolean[grid.length];
		for(int i=0;i<grid.length;i++) {
			if(!vis[i]) {
				topoSort(i, vis, st, adj);
			}
		}
		
		int dis[]=new int[grid.length];
		for(int i=0;i<dis.length;i++) dis[i]=Integer.MAX_VALUE;
		
		dis[0]=0;	//source node
		while(!st.isEmpty()) {
			int node=st.pop();
			if(dis[node] != Integer.MAX_VALUE) {
			for(int i=0;i<adj.get(node).size();i++) {
				int v=adj.get(node).get(i).node;
				int wt=adj.get(node).get(i).weight;
				if(dis[node]+wt<dis[v]) {
					dis[v]=dis[node]+wt;
				}
			}
		  }
		}
		return dis;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]={{0, 1, 5},
		        {0, 2, 3},
		        {1, 3, 6},
		        {1, 2, 2},
		        {2, 4, 4},
		        {2, 5, 2},
		        {2, 3, 7},
		        {3, 4, -1},
		        {4, 5, -2}};
		PShortestPathInDAG obj = new PShortestPathInDAG();
		int res[]=obj.shortestPath(grid);
		for(int i: res)
			System.out.println(i);
	}

}
