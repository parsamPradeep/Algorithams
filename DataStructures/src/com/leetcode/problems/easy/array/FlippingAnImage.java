package com.leetcode.problems.easy.array;
/*
 Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
public class FlippingAnImage {
	public static int[][] flipAndInvertImage(int[][] images) {
        for(int i=0;i<images.length;i++){
            int mid=images.length/2;
            int l=images[i].length-1;
            if(images[i].length%2==0){
            for(int j=0;j<mid;j++){
                int tmp=(images[i][j]==1)?0:1;
                images[i][j]=(images[i][l]==1)?0:1;
                images[i][l]=tmp;
                l--;
            }
            }else{
              for(int j=0;j<=mid;j++){
                int tmp=(images[i][j]==1)?0:1;
                images[i][j]=(images[i][l]==1)?0:1;
                images[i][l]=tmp;
                l--;
            }  
            }
        }
        return images;
    }
	public static void main(String[] args) {
		int images[][]= { {1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		images=flipAndInvertImage(images);
		for(int i=0;i<images.length;i++) {
			for(int j=0;j<images[0].length;j++)
				System.out.print(images[i][j]+ " ");
			System.out.println();
		}
	}

}
