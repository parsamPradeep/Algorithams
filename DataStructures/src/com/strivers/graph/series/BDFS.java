package com.strivers.graph.series;

import java.util.ArrayList;

public class BDFS {
	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer>li=new ArrayList<>();
        int[] visited=new int[V];

        dfs(0,visited,li,adj);
        return li;
    }
    void dfs(int i,int[] visited,ArrayList<Integer>li,ArrayList<ArrayList<Integer>> adj){
        visited[i]=1;
        li.add(i);
        for(Integer it:adj.get(i)){
            if(visited[it]==0){
                dfs(it,visited,li,adj);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
