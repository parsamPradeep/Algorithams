package com.strivers.graph.series;

import java.util.LinkedList;
import java.util.Queue;

public class FRottenOrange {
	  public class Pair{
	        private int row;
	        private int col;
	        Pair(int row, int col){
	            this.row=row;
	            this.col=col;
	        }
	    }
	    public int delRow[]={-1, 0, 1, 0};
	    public int delCol[]={0, 1, 0, -1};
	    public int count=-1;
	    public  int fresh_count=0;
	    public int orangesRotting(int[][] grid) {
	        boolean rotten[][]=new boolean[grid.length][grid[0].length];
	        Queue<Pair> queue=new LinkedList<Pair>();
	       
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[i].length;j++){
	                if(grid[i][j]==2){
	                    queue.add(new Pair(i,j));
	                } else if(grid[i][j]==1){
	                    fresh_count++;
	                }
	            }
	        }
	        int n=grid.length;
	        int m=grid[0].length;
	        if(fresh_count==0) return 0;
	         while(!queue.isEmpty()){
	        ++count;
	        int size=queue.size();
	        for(int k=0;k<size;k++){
	        int row=queue.peek().row;
	        int col=queue.peek().col;
	        queue.remove();
	        for(int i=0;i<4;i++){
	            int r=row+delRow[i];
	            int c=col+delCol[i];
	            if(r>=0 && r<n && c>=0 && c<m && !rotten[r][c] && grid[r][c]==1){
	                rotten[r][c]=true;
	                fresh_count--;
	                queue.add(new Pair(r,c));
	            }
	        }
	        }
	    }
	        return fresh_count==0?count:-1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]={{2,1,1},{1,1,0},{0,1,1}};
		FRottenOrange ob=new FRottenOrange();
		System.out.println(ob.orangesRotting(arr)); //Ans 4
	}

}
