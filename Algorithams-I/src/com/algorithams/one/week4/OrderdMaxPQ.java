package com.algorithams.one.week4;

public class OrderdMaxPQ<Key extends Comparable<Key>> {
	private Key pq[];
	private int n;

	OrderdMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public boolean less(Key i, Key j) {
		return i.compareTo(j) < 0;
	}

	public void insert(Key key) {
		int i = n - 1;
		while (i >= 0 && less(key, pq[i])) {
			pq[i + 1] = pq[i];
			i--;
		}
		pq[i + 1] = key;
		n++;
	}

	public Key delete() {
		return pq[--n];
	}

}
