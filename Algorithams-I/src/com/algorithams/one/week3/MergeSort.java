package com.algorithams.one.week3;

public class MergeSort {

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
	
	public void sort(Comparable arr[],Comparable aux[],  int l,int r) {
		if(r<=l)
			return;
		int mid=l+(r-l)/2;
		sort(arr,aux,l,mid);
		sort(arr,aux,mid+1,r);
		merge(arr,aux,mid,l,r);
		
	}
	public void sort(Comparable arr[]) {
		Comparable aux[]=new Comparable[arr.length];	
		sort(arr,aux,0,arr.length-1);
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
