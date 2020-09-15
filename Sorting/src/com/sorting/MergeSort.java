package com.sorting;

public class MergeSort {
	public void merge(int arr[], int l, int mid, int r) {
		System.out.println("Left :-"+l+"Right :-"+r+"Mid :-"+mid);
		int Ln=mid-l+1;
		int Rn=r-mid;
		int L[]=new int[Ln];
		int R[]=new int[Rn];
		for(int i=0;i<Ln;i++)
			L[i]=arr[l+i];
		for(int j=0;j<Rn;j++)
			R[j]=arr[mid+1+j];
		int i=0;int j=0; int k=l;
		while(i<Ln&&j<Rn) {
			if(L[i]<=R[j]) {
				arr[k]=L[i];
				i++;
			}else {
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<Ln) {
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<Rn) {
			arr[k]=R[j];
			j++;
			k++;
		}
		
	}
	
	public void sort(int arr[], int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			sort(arr,l,mid);
			sort(arr,mid+1,r);
			merge(arr,l,mid,r);
		}
	}

	public static void main(String[] args) {
		int arr[]= {12,10,18,7,2};
		MergeSort ms=new MergeSort();
		ms.sort(arr, 0, arr.length-1);
		for(int i:arr) {
			System.out.println(i);
		}
		
	}

}
