package com.strivers.graph.series;

import java.util.LinkedList;
import java.util.Queue;

public class EFloodFill {
	public int [] delRow={-1,0,1,0};
    public int [] delCol={0,1,0,-1};
    
//Approach - 1 DFS
    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int iniColor=image[sr][sc];
        dfs(sr,sc,ans,image,color,iniColor);
        return ans;
    }
    public void dfs(int row, int col, int ans[][], int image[][], int color, int iniColor){
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int r=row+delRow[i];
            int c=col+delCol[i];
            if(r>=0 && r<n && c>=0 && c<m && image[r][c]==iniColor && ans[r][c]!=color){
                dfs(r, c, ans, image, color, iniColor);
            }
        }
    }
    
//Approach - 2 BFS
	    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
	        int ans[][]=image;
	        int iniColor=image[sr][sc];
	        int n=image.length;
	        int m=image[0].length;
	        Queue<int[]> q=new LinkedList<>();
	        q.add(new int[]{sr, sc});
	        while(!q.isEmpty()){
	            int arr[]=q.poll();
	            int r=arr[0];
	            int c=arr[1];
	            ans[r][c]=color;
	            for(int i=0;i<4;i++){
	                int nr=r+delRow[i];
	                int nc=c+delCol[i];
	                if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==iniColor && ans[nr][nc]!=color)
	                    q.add(new int[]{nr,nc});
	            }
	        }

	        return ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EFloodFill obj=new EFloodFill();
		int arr1[][]={{1,1,1},{1,1,0},{1,0,1}};
		arr1=obj.floodFill1(arr1, 1, 1, 2);
		for(int a[]: arr1)
			for(int i: a)
			System.out.print(i+", "); //Ans [[2,2,2],[2,2,0],[2,0,1]]
		System.out.println();
		int arr2[][]={{0,0,0},{0,0,0}};
		arr2=obj.floodFill2(arr2, 0, 0, 0);
		for(int a[]: arr2)
			for(int i: a)
			System.out.print(i+", "); //Ans [[0,0,0],[0,0,0]]
		

	}

}
