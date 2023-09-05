package com.strivers.graph.series;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OAlienDictionary {
	public int[] topo(List<List<Integer>> adj) {
		int indegree[] = new int[adj.size()];
		for (int i = 0; i < adj.size(); i++)
			for (int adjc : adj.get(i))
				indegree[adjc]++;

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < adj.size(); i++)
			if (indegree[i] == 0)
				q.add(i);
		int topo[] = new int[adj.size()];
		int i = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			topo[i++] = node;
			for (int adjc : adj.get(node)) {
				indegree[adjc]--;
				if (indegree[adjc] == 0)
					q.add(adjc);
			}
		}
		return topo;
	}
	public String alienDic(String dic[]) {
		List<List<Integer>> adj=new ArrayList<>();
		String res="";
		for(int i=0;i<dic.length;i++) adj.add(new ArrayList<>());
		for(int i=0;i<dic.length-1;i++) {
			String str1=dic[i];
			String str2=dic[i+1];
			int len=Math.min(str1.length(), str2.length());
			for(int j=0;j<len;j++) {
				if(str1.charAt(j)!=str2.charAt(j)) {
					adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
					break;
				}
			}
		}
		int topo[]=topo(adj);
		for(int i=0;i<topo.length;i++) {
			res=res+String.valueOf((char)(topo[i]+(int)'a'));
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[]= {"baa","abcd","abca","cab","cad"};
		OAlienDictionary obj=new OAlienDictionary();
		System.out.println(obj.alienDic(arr));
	}

}
