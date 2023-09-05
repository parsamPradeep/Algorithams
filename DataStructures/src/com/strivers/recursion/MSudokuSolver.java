package com.strivers.recursion;

public class MSudokuSolver {
	 public void solveSudoku(char[][] board) {
	        solve(board);
	    }
	    public boolean solve(char[][] board){
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[i].length;j++){
	                if(board[i][j]=='.'){
	                    for(char c='1';c<='9';c++){
	                        if(isValid(i,j,board,c)){
	                            board[i][j]=c;
	                            if(solve(board)==true)
	                                return true;
	                            else
	                                board[i][j]='.';
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public boolean isValid(int row, int col, char board[][], char c){
	        for(int i=0;i<9;i++){
	            if(board[i][col]==c) return false;
	            if(board[row][i]==c) return false;
	            if(board[3*(row/3)+i/3][3*(col/3)+i/3]==c) return false;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][]={
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
				};
		MSudokuSolver obj = new MSudokuSolver();
		obj.solveSudoku(board);
	}
}
