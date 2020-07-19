package com.algorithams.one;

import java.util.Scanner;


public class PathCompressionQuickUnion {
	private int[] id;
	private int[] sz;
	private int count;

	public PathCompressionQuickUnion(int N) {
		id=new int[N];
		count=N;
		for(int i=0;i<N;i++) {
			id[i]=i;
			sz[i]=1;
		}
	}
	public int root(int i) {
		while (i!=id[i])
			i=id[i];
		return i;
	}
	public void union(int p, int q) {
		int i=root(id[p]);
		int j=root(id[q]);
		if(i==j) return;
		if(sz[i]<sz[j]) {
			id[i]=j;
			sz[j]+=sz[i];
		}
		else
		{
			id[j]=i;
			sz[i]+=sz[j];
		}
		
	}
	
	public boolean connected(int p, int q) {
		return root(id[p])==root(id[q]);
	}
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the number of nodes");
		int num=sc.nextInt();
		PathCompressionQuickUnion qf=new PathCompressionQuickUnion(num);
		System.out.println("Select any one option\n");
		System.out.println("1. enter the source and destination node to be connected");
		System.out.println("2. exit");
		int option=sc.nextInt();
		while(option==1) {
			System.out.println("Enter the source node\n");
			int src=sc.nextInt();
			System.out.println("Enter the destination node\n");
			int des=sc.nextInt();
			boolean is_connected=qf.connected(src,des);
			if(!is_connected) {
				qf.union(src, des);
				System.out.println("Connected nodes are :"+src+" "+des);
			}
			else
				System.out.println("Node alreday connected either directly or indireclty");
		}
		
	}

}
