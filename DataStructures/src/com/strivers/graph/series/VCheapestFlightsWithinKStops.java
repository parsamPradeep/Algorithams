package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VCheapestFlightsWithinKStops {
	public class Pairs{
        int first;
        int second;
        Pairs(int first,int second){
             this.first=first;
             this.second=second;
        }
    }

    public class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first,int second,int third){
             this.first=first;
             this.second=second;
             this.third=third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pairs>> adj=new ArrayList<>();
		for(int i=0;i<=flights.length;i++) adj.add(new ArrayList<>());
		
		for(int arr[]:flights) {
				adj.get(arr[0]).add(new Pairs(arr[1], arr[2]));
		}
		return dijkstra(adj, src, dst, k);
    }
    public int dijkstra(List<List<Pairs>> adj, int src, int dst, int k) {
		int dist[]=new int[adj.size()];
		Queue<Tuple> q=new LinkedList<>();
		q.add(new Tuple(0,src, 0));
		for(int i=0;i<dist.length;i++) dist[i]=Integer.MAX_VALUE;
		dist[src]=0;
		
		while(!q.isEmpty()) {
            Tuple curr=q.poll();
			int stops=curr.first;
			int node=curr.second;
            int cost=curr.third;

			for(int i=0;i<adj.get(node).size();i++) {
				int adjnode=adj.get(node).get(i).first;
                int edw=adj.get(node).get(i).second;

				if(cost+edw < dist[adjnode] && stops<=k) {
					dist[adjnode]=cost+edw;
					q.add(new Tuple(stops+1, adjnode, cost+edw));
				}
				
			}
		}
        if(dst<adj.size() && dist[dst]!=Integer.MAX_VALUE) return dist[dst];
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gpraph[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
		VCheapestFlightsWithinKStops obj=new VCheapestFlightsWithinKStops();
		System.out.println(obj.findCheapestPrice(4, gpraph, 0, 3, 1)); //ans 700
	}

}
