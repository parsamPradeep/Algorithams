package com.strivers.graph.series;

import java.util.LinkedList;
import java.util.Queue;

public class DNumberOfIsLands {
//Approach-1 DFS
	public static int numIslands1(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void dfs(int i, int j, char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
    }
	
  // Approach - 2 BFS
    public static class Pair{
        private int row;
        private int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public static int numIslands(char[][] grid) {
        int count = 0;
        boolean visited[][]=new boolean[grid.length+1][grid[0].length+1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void bfs(int ro, int co, char[][] grid, boolean visited[][]){
        visited[ro][co]=true;
        Queue<Pair> queue=new LinkedList<Pair>();
        queue.add(new Pair(ro, co));
        
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            queue.remove();

                if(col-1>=0 && col-1<grid[0].length && grid[row][col-1]=='1'&& !visited[row][col-1]){
                    visited[row][col-1]=true;
                    queue.add(new Pair(row,col-1));
                }
                if(col+1>=0 && col+1<grid[0].length && grid[row][col+1]=='1'&& !visited[row][col+1]){
                    visited[row][col+1]=true;
                    queue.add(new Pair(row,col+1));
                }
                if(row+1>=0 && row+1<grid.length && grid[row+1][col]=='1'&& !visited[row+1][col]){
                    visited[row+1][col]=true;
                    queue.add(new Pair(row+1,col));
                }
                if(row-1>=0 && row-1<grid.length && grid[row-1][col]=='1'&& !visited[row-1][col]){
                    visited[row-1][col]=true;
                    queue.add(new Pair(row-1,col));
                }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][]={
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
				};
		char grid2[][]={
				  {'1','1','0','0','0'},
				  {'1','1','0','0','0'},
				  {'0','0','1','0','0'},
				  {'0','0','0','1','1'}
				};
		System.out.println(numIslands1(grid));	// Ans 1
		System.out.println(numIslands(grid2)); // Ans 3
		
	}

}
