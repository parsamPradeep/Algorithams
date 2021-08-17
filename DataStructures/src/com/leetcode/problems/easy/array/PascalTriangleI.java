package com.leetcode.problems.easy.array;
/*
 Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 */
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleI {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List zList = new ArrayList();
		zList.add(1);
		list.add(zList);
		for (int i = 1; i < numRows; i++) {
			List iList = new ArrayList();
			if (i < 2) {
				iList.add(1);
				iList.add(1);
			} else {
				iList.add(1);
				if ((i - 1) >= 0)
					for (int l = 0; l < list.get(i - 1).size() - 1; l++)
						iList.add(list.get(i - 1).get(l) + list.get(i - 1).get(l + 1));

				iList.add(1);
			}
			list.add(iList);
		}
		return list;
	}

	public static void main(String[] args) {
		int numRows=5;
		List<List<Integer>> res=generate(numRows);
		System.out.println(res);
	}

}
