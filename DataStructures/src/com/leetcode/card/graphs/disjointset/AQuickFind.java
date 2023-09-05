package com.leetcode.card.graphs.disjointset;

public class AQuickFind {
	private int[] id;
	private int count;

	public AQuickFind(int N) {
		id = new int[N];
		count = N;
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public int find(int i) {
		return id[i];
	}

	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid)
				id[i] = qid;
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
