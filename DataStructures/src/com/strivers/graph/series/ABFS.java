package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ABFS {
	public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<Integer>();
         Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0]=true;
       
        while (!q.isEmpty()) {
            int u = q.remove();
            ans.add(u);
            for (int vi : adj.get(u)) {
                if (!vis[vi]) {
                    vis[vi] = true;
                    q.add(vi);
                }
            }
        }

        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
