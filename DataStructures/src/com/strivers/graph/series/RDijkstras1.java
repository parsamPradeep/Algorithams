package com.strivers.graph.series;

import java.util.*;

public class RDijkstras1 {
	public class Pair{
		int node;
		int distance;
		Pair(int distance,int node){
			this.node=node;
			this.distance=distance;
		}
	}
	public int[] dijktra(List<List<List<Integer>>> adj, int N, int source) {
		 PriorityQueue<Pair> pQueue = new PriorityQueue<Pair>((x,y)-> x.distance-y.distance);
		 int dist[]=new int[N];
		 for(int i=0;i<N;i++) dist[i]=Integer.MAX_VALUE;
		 dist[source]=0;
		 pQueue.add(new Pair(0, source));
		 while(!pQueue.isEmpty()) {
			 int dis=pQueue.peek().distance;
			 int node=pQueue.peek().node;
			 pQueue.poll();
			 for(int i=0;i<adj.get(node).size();i++) {
				 int edgeweight=adj.get(node).get(i).get(1);
				 int adjnode=adj.get(node).get(i).get(0);
				 
				 if(dis+edgeweight < dist[adjnode]) {
					 dist[adjnode]=dis+edgeweight;
					 pQueue.add(new Pair(dist[adjnode], adjnode));
				 }
			 }
		 }
		return dist;	 
	}
	
	public int[] shortestPath(int[][] graph, int N) {
		List<List<List<Integer>>> adj = new ArrayList<>();
		for(int i=0;i<N;i++) { 
			adj.add(new ArrayList<>(new ArrayList<>()));
		} 
		
		for(int arr[] :graph) 
			adj.get(arr[0]).add(new ArrayList<>(Arrays.asList(arr[1], arr[2])));
			System.out.println("Edges"+adj);
			return dijktra(adj, N, 0);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][]= {{0,1,4},{0,2,4},
						{1,0,4},{1,2,2},
						{2,0,4},{2,1,2},{2,3,3},{2,4,1},{2,5,6},
						{3,2,3},{3,5,2},
						{4,2,1},{4,5,3},
						{5,3,2},{5,2,6},{5,4,3}};
		RDijkstras1 obj=new RDijkstras1();
		
		int res[]=obj.shortestPath(graph, 6);
		for(int i=0;i<res.length;i++)
			System.out.println(res[i]); //Ans [0,4,4,7,5,8]
						
	}

}
