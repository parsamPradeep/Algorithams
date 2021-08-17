package com.leetcode.problems.easy.array;

public class FindNearestPointThatHastheSameXorYCoordinate {
	public static int nearestValidPoint(int x, int y, int[][] points) {
		Integer res = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] == x || points[i][1] == y) {
				int dist = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
				if (dist < res) {
					res = dist;
					index = i;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int x = 3;
		int y = 4;
		int points[][] = { { 1, 2 }, { 3, 1 }, { 2, 4 }, { 2, 3 }, { 4, 4 } };
		System.out.println(nearestValidPoint(x, y, points));

	}

}
