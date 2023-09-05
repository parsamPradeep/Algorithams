package com.leetcode.card.graphs.disjointset;

public class FNumberOfProvinces {
	public static int provinces(int [][] isConnected) {
		 if (isConnected == null || isConnected.length == 0) {
	            return 0;
	        }

	        int n = isConnected.length;
	        CUnionByRank uf = new CUnionByRank(n);
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (isConnected[i][j] == 1) {
	                    uf.union(i, j);
	                }
	            }
	        }

	        return uf.getCount();
	}
	
	//Approach - 2
	 public int findCircleNum(int[][] M) {
	        int N = M.length;
	        boolean[]visited = new boolean[N];
	        int count = 0;
	        
	        for(int i = 0; i < N ;i++){
	            if(!visited[i]){
	                count++;
	                dfs(M,i,visited);
	            }
	        }
	      return count;  
	    }
	    
	    
	    private void dfs(int[][]M,int i,boolean[]visited){
	        for(int j = 0 ; j < M[i].length ; j++){
	            if(!visited[j] && M[i][j] != 0){
	                visited[j] = true;
	                dfs(M,j,visited);
	            }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
