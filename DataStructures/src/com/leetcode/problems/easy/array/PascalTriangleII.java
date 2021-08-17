package com.leetcode.problems.easy.array;
/*
Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 */
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	
	public static List<Integer> getRowOfPascal(int row){
		List<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<=row;i++) {
			list.add(1);
			for(int j=i-1;j>0;j--) {
				list.set(j, list.get(j-1)+list.get(j));
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int row=5;
		System.out.println(getRowOfPascal(row));
	}

}
