package com.algorithams.one.week4;

public class UnOrderedMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq; 
	public int N;
	
	public UnOrderedMaxPQ(int capacity) {
		pq=(Key[]) new Comparable[capacity];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public void insert(Key x) {
		pq[N++]=x;
	}
	public Key delMax() {
		int max=0;
		for(int i=0;i<N;i++)
			if(less(max,i))
				max=i;
		exchange(max,N-1);
		return pq[N--];
	}
	public void exchange(int i,int j) {
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
	}
	public boolean less(int i,int j) {
		if( pq[i].compareTo(pq[j])<0)
			return true;
		else 
			return false;
	}
	
}
