package com.strivers.recursion;

import java.util.ArrayList;
import java.util.List;

public class BSubsequence {
	public void printSubsequence(int i, int arr[], List<Integer> ssq) {
		if(i>=arr.length) {
			System.out.print(ssq+" ");
			return;
		}
		ssq.add(arr[i]);
		printSubsequence(i+1, arr, ssq);
		ssq.remove((Integer)(arr[i]));
		printSubsequence(i+1, arr, ssq);
	}
	//TC:- O(2 pow n) SC:-
	public static void main(String args[]) {
		BSubsequence obj=new BSubsequence();
		List<Integer> list=new ArrayList<Integer>();
		int arr[]= {2, 7, 3, 6, 1};
		obj.printSubsequence(0, arr, list);
	}
}
