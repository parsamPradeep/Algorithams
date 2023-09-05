package com.leetcode.card.graphs.disjointset;

public class BQuickUnion {
	private int[] id;
	private int count;

	public BQuickUnion(int N) {
		id = new int[N];
		count = N;
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public int find(int i) {
		while (i != id[i])
			i = id[i];
		return i;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i != j)
			id[i] = j;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
