package com.strivers.graph.series;

import java.util.PriorityQueue;

public class UPathwithMinimumEffort {
	public int [] delRow={-1,0,1,0};
    public int [] delCol={0,1,0,-1};
    public class Points{
        int row;
        int dist;
        int col;
         Points(int dist, int row, int col){
             this.row=row;
             this.dist=dist;
             this.col=col;
         }
    }
    public int minimumEffortPath(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] visited = new int[row][col];

        PriorityQueue<Points> queue = new PriorityQueue<Points>((x,y)-> x.dist - y.dist);
        queue.add(new Points(0, 0, 0));
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                visited[i][j]=Integer.MAX_VALUE;
            }
        }
        visited[0][0]=0;
        while (!queue.isEmpty()) {
                Points curPos = queue.poll();

                if (curPos.row == row - 1 && curPos.col == col - 1) {
                   return curPos.dist;
                }

                for(int i=0;i<4;i++){
                    int nextX = curPos.row + delRow[i];
                    int nextY = curPos.col + delCol[i];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                        continue;
                    }

                    int maxValue=Math.max(curPos.dist,Math.abs(grid[curPos.row][curPos.col]-grid[nextX][nextY]));
                    if(maxValue < visited[nextX][nextY]){
                        visited[nextX][nextY]=maxValue;
                        queue.add(new Points(maxValue,nextX, nextY));
                    }
                }
                
            
        }

        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]={{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		UPathwithMinimumEffort obj=new UPathwithMinimumEffort();
		System.out.println(obj.minimumEffortPath(grid)); // Ans 0
	}

}
