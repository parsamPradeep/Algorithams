package com.algorithams.one.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solution 
{
private final int V; 
private final List<Integer> adj[]; 

public Solution(int V)  
{ 
    this.V = V; 
    adj = new List[V]; 
      
    for (int i = 0; i < V; i++) 
        adj[i]=new ArrayList<>(); 
} 
  
// This function is a variation of DFSUtil() in  
// https://www.geeksforgeeks.org/archives/18212 
private boolean isCyclicUtil(int i, boolean[] visited, 
                                  boolean[] recStack)  
{ 
      
    // Mark the current node as visited and 
    // part of recursion stack 
    if (recStack[i]) 
        return true; 

    if (visited[i]) 
        return false; 
          
    visited[i] = true; 

    recStack[i] = true; 
   // List<Integer> children = adj.get(i); 
      
   // for (Integer c: children) 
       // if (isCyclicUtil(c, visited, recStack)) 
          //  return true; 
              
    //recStack[i] = false; 

    return false; 
} 

private void addEdge(int source, int dest) { 
    adj[source].add(dest); 
} 

// Returns true if the graph contains a  
// cycle, else false. 
// This function is a variation of DFS() in  
// https://www.geeksforgeeks.org/archives/18212
public Iterable<Integer> adj(int v){
	return adj[v];
}
private boolean isCyclic(Solution graph)  
{ 
      
    // Mark all the vertices as not visited and 
    // not part of recursion stack 
    boolean[] visited = new boolean[V]; 
    boolean[] recStack = new boolean[V]; 
      
      
    // Call the recursive helper function to 
    // detect cycle in different DFS trees 
    for (int i = 0; i < V; i++) 
       for(int j:graph.adj(i)) {
    	   if(!visited[j])
    		   visited[j]=true;
    	   else
    		   return true;
       }

    return false; 
} 

// Driver code 
public static void main(String[] args) 
{ 
	Solution graph = new Solution(5); 
	graph.addEdge(0, 1); 
	graph.addEdge(0, 2); 
	graph.addEdge(0, 3); 
    graph.addEdge(1, 3);
	graph.addEdge(2, 4); 
      
    if(graph.isCyclic(graph)) 
        System.out.println("Graph contains cycle"); 
    else
        System.out.println("Graph doesn't "
                                + "contain cycle"); 
} 
}