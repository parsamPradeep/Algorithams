package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.strivers.graph.series.RDijkstras1.Pair;

public class TPrintShortestPath {
	public class Pair{
		int node;
		int dist;
		Pair(int dist, int node){
			this.dist=dist;
			this.node=node;
		}
	}
	public int dijktra(List<List<List<Integer>>> adj, int N) {
		int parent[]=new int[N+1];
		int dist[]=new int[N+1];
		
		PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
		
		 for(int i=0;i<=N;i++) {
			 dist[i]=Integer.MAX_VALUE;
			 parent[i]=i;
		 }
		 dist[1]=1;
		 pq.add(new Pair(0, 1));
		 System.out.println("Edges"+adj);
		 while(!pq.isEmpty()) {
			 int dis=pq.peek().dist;
			 int node=pq.peek().node;
			 pq.poll();
			 for(int i=0;i<adj.get(node).size();i++) {
				 int edgeweight=adj.get(node).get(i).get(1);
				 int adjnode=adj.get(node).get(i).get(0);
				 
				 if(dis+edgeweight < dist[adjnode]) {
					 dist[adjnode]=dis+edgeweight;
					 parent[adjnode]=node;
					 pq.add(new Pair(dist[adjnode], adjnode));
				 }
			 }
		 }
		 List<Integer> res=new ArrayList<Integer>();
		 int node=N;
		 while(parent[node]!=node) {
			 res.add(node);
			 node=parent[node];
		 }
		 res.add(1);
		 Collections.reverse(res);
		 System.out.println("Shortest Path"+res);
		 return dist[N];
		 
	}
	public int printShortestPath(int graph[][], int N) {
		List<List<List<Integer>>> adj = new ArrayList<>();
		for(int i=0;i<=N;i++) { 
			adj.add(new ArrayList<>(new ArrayList<>()));
		} 
		
		for(int arr[] :graph) 
			adj.get(arr[0]).add(new ArrayList<>(Arrays.asList(arr[1], arr[2])));
		return dijktra(adj, N);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][]= {{1,4,1},{1,2,2},
				{2,1,2},{2,5,5},{2,3,4},
				{3,4,3},{3,2,4},{3,5,1},
				{4,1,1},{4,3,3},
				{5,2,5},{5,3,1}
				};
		TPrintShortestPath obj = new TPrintShortestPath();
		System.out.println("shortest path sum "+obj.printShortestPath(graph, 5));
	}

}
