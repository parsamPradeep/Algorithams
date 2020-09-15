package com.algorithams.one.week3;

public class MergeSortBU {

	private boolean less(Comparable i,Comparable j) {
		if(i.compareTo(j)>0)
			return true;
		else
			return false;
	}
	public void merge(Comparable arr[],Comparable aux[],int mid,int l, int r) {
		for(int i=0;i<arr.length;i++)
			aux[i]=arr[i];
		int i=l, j=mid+1;
		for(int k=l;k<=r;k++) {
			if(i>mid)
				arr[k]=aux[j++];
			else if(j>r)
				arr[k]=aux[i++];
			else if(less(aux[i],aux[j]))
				arr[k]=aux[j++];
			else
				arr[k]=aux[i++];
		}
	}
	

	public void sort(Comparable arr[]) {
		int N=arr.length;
		Comparable aux[]=new Comparable[N];
		for(int sz=1;sz<N;sz=sz+sz) {
			for(int lo=0;lo<N-sz;lo+=sz+sz) {
				merge(arr, aux,lo+sz-1,lo,Math.min(lo+sz+sz-1, N-1));
			}
		}
		
	}
	public static void main(String[] args) {
		Comparable arr[]= {12,10,18,7,2};
		MergeSort ms=new MergeSort();
		ms.sort(arr);
		for(Comparable i:arr) {
			System.out.println(i);
		}
		

	}

}
