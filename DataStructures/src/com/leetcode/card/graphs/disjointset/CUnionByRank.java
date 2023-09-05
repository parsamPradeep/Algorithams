package com.leetcode.card.graphs.disjointset;

public class CUnionByRank {
	private int[] root;
	private int[] rank;
	private int count = 0;
	public CUnionByRank(int size) {
		root = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			root[i] = i;
			rank[i] = 1;
		}
	}

	public int find(int x) {
		while (x != root[x]) {
			x = root[x];
		}
		return x;
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			count++;
			if (rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				root[rootX] = rootY;
			} else {
				root[rootY] = rootX;
				rank[rootX] += 1;
			}
		}
	}

	public boolean connected(int x, int y) {
		return find(x) == find(y);
	}
	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
