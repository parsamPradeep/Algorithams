package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JIsGraphBipartite {
	// Approach - 1 DFS
	public boolean isBipartite1(int[][] graph) {
        int[] color = new int[graph.length + 1];
        List<List<Integer>> adj = new ArrayList<>(graph.length + 1);
        for(int i = 0; i <= graph.length; i++) adj.add(new ArrayList<Integer>());
        for(int i=0;i<graph.length;i++)
            for(int j=0;j<graph[i].length;j++) 
                adj.get(i).add(graph[i][j]);
        
        
        for(int i = 1; i <= graph.length; i++) {
            if(color[i] == 0) {
                if(dfs(i,1, adj, color)==false) return false;
            }
        }
        return true;
    }
     public boolean dfs(int node, int col, List<List<Integer>> adjc, int color[]){
        color[node]=col;
        for(int adj: adjc.get(node)){
            if(color[adj]==0){
                int nCol=col==1?2:1;
                if(dfs(adj, nCol,adjc, color)==false) return false;
            }else if(color[node]==color[adj]){
                return false;
            }
        }
        return true;
    }
     
   // Approach - 2 BFS
     public boolean isBipartite2(int[][] graph) {
         int[] color = new int[graph.length + 1];
        List<List<Integer>> adj = new ArrayList<>(graph.length + 1);
        for(int i = 0; i <= graph.length; i++) adj.add(new ArrayList<Integer>());
        for(int i=0;i<graph.length;i++) {
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        
        for(int i = 0; i < graph.length; i++) {
            if(color[i] == 0) {
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for(int nb : adj.get(cur)) {
                        if(color[nb] == 0) {
                            color[nb] = color[cur] == 1 ? 2 : 1;
                            q.add(nb);
                        } else {
                            if(color[nb] == color[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]={{1,2,3},{0,2},{0,1,3},{0,2}};
		JIsGraphBipartite obj=new JIsGraphBipartite();
		System.out.println(obj.isBipartite1(arr)); //Ans false
	}

}
