package com.strivers.recursion;

import java.util.ArrayList;
import java.util.List;

public class CSubsquenceWithSun {
	
//	fun(){
//		basecase
//			return 1;
//			return 0;
//		left=fun();
//		right=fun();
//		return left+right;
//	}

	public void printSubsequence(int i, int arr[], List<Integer> ssq, int sum, int tempSum) {

		if (i >= arr.length) {
			if (sum == tempSum) {
				System.out.println(ssq);
			}
			return;
		}

		ssq.add(arr[i]);
		tempSum += arr[i];
		printSubsequence(i + 1, arr, ssq, sum, tempSum);
		ssq.remove((Integer)(arr[i]));
		tempSum -= arr[i];
		printSubsequence(i + 1, arr, ssq, sum, tempSum);
	}

	// Print only one answer
	public boolean printOneSubsequence(int i, int arr[], List<Integer> ssq, int sum, int tempSum) {

		if (i >= arr.length) {
			if (sum == tempSum) {
				System.out.println("printOneSubsequence :"+ssq);
				return true;
			}
			return false;
		}

		ssq.add(arr[i]);
		tempSum += arr[i];
		if (printOneSubsequence(i + 1, arr, ssq, sum, tempSum))
			return true;
		ssq.remove((Integer)(arr[i]));
		tempSum -= arr[i];
		if (printOneSubsequence(i + 1, arr, ssq, sum, tempSum))
			return true;
		return false;
	}

	// Print count of number of subsequence
	public int printNumofSubsequence(int i, int arr[],int sum, int tempSum) {

		if (i >= arr.length) {
			if (sum == tempSum) {
				return 1;
			}
			return 0;
		}

		tempSum += arr[i];
		int left=printNumofSubsequence(i + 1, arr, sum, tempSum);
		
		tempSum -= arr[i];
		int right=printNumofSubsequence(i + 1, arr, sum, tempSum);
		
		return right+left;
	}

	public static void main(String args[]) {
		CSubsquenceWithSun obj = new CSubsquenceWithSun();
		List<Integer> list = new ArrayList<Integer>();
		int arr[] = { 1, 5, 2, 1 };
		obj.printSubsequence(0, arr, list, 2, 0);
		obj.printOneSubsequence(0, arr, list, 2, 0);
		System.out.println(obj.printNumofSubsequence(0, arr, 2,0));
	}
}
