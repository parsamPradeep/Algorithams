package com.strivers.graph.series;

import java.util.*;

//Shortest Path in Undirected Graph with Unit Weights
public class QShortestPathinUndirectedGraph {
	
	public int[] bfs(List<List<Integer>> adj, int N) {
		int dist[]=new int[N+1];
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {0,0});
		for(int i=0;i<dist.length;i++) dist[i]=Integer.MAX_VALUE;
		dist[0]=0;
		System.out.println(adj);
		while(!q.isEmpty()) {
			int node=q.peek()[0];
			int dis=q.peek()[1];
			q.poll();
			for(int i=0;i<adj.get(node).size();i++) {
				int adjnode=adj.get(node).get(i);
				if(dis+1 < dist[adjnode]) {
					dist[adjnode]=dis+1;
					q.add(new int[]{adjnode, dis+1});
				}
				
			}
		}
		return dist;
	}
	
	public int[] shortestPath(int graph[][], int nodes) {
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<=nodes;i++) adj.add(new ArrayList<>());
		
		for(int arr[]:graph) {
				adj.get(arr[0]).add(arr[1]);
		}
		return bfs(adj, nodes);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][]= {{0,1},{0,3},
				{1,0},{1,2},{1,3},
				{2,1},{2,6},
				{3,0},{3,4},
				{4,3},{4,5},
				{5,4},{5,6},
				{6,2},{6,5},{6,7},{6,8},
				{7,6},{7,8},
				{8,6},{8,7}
				};
		QShortestPathinUndirectedGraph obj=new QShortestPathinUndirectedGraph();
		int res[]=obj.shortestPath(graph, 8);
		for(int i: res)
			System.out.println(i); // Ans [0,1,2,1,2,3,3,4,4]

	}

}
