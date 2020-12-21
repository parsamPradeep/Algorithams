package com.algorithams.one.week4;

public class BinaryHeap<Key extends Comparable<Key>> {
	private Key pq[];
	private int N=0;

	public BinaryHeap(int capacity) {
		pq=(Key[]) new Comparable[capacity+1];
	}
	
	private void swim(int k) {
		while(k>1 && less(k/2,k)) {
			exchange(k,k/2);
		}
	}
	
	private void sink(int k) {
		while(2*k<=N) {
			int j=2*k;
			if(j< N && less(j,j+1))
				j++;
			if(!less(k,j))
				break;
			exchange(k,j);
			k=j;
		}
	}
	
	private void insert(Key x) {
		pq[++N]=x;
		swim(N);
	}
	
	private Key delMax() {
		Key max=pq[1];
		exchange(1,N--);
		sink(1);
		pq[N+1]=null;
		return max;
	}
	
	private boolean less(int i,int j) {
		return pq[i].compareTo(pq[j])<0;
	}
	
	private void exchange(int i, int j) {
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
	}
	
}
