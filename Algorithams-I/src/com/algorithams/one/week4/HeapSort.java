package com.algorithams.one.week4;

public class HeapSort {

	
	public void sort(Comparable[] a) {
		int N =a.length;
		for(int k=N/2;k>=1;k++)
			sink(a,k,N);
		while(N>1) {
			
		}
	}
	private void sink(Comparable[] a,int k, int N ) {
		while(2*k<=N) {
			int j=2*k;
			if(less(a,j,j+1))
				j++;
			if(!less(a,k,j))
				break;
			exchange(a,k,j);
		}
	}
	private boolean less(Comparable[] a,int i,int j) {
		return a[i].compareTo(a[j])<0;
	}
	private void exchange(Comparable[] a, int i,int j) {
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
