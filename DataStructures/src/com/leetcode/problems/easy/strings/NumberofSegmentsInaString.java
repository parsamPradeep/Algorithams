package com.leetcode.problems.easy.strings;

public class NumberofSegmentsInaString {
	public static int countSegment(String s) {
		if(s.equals(" ")||s==null)
			return 0;
		int count=0;
		char arr[]=s.toCharArray();
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=' ')
				count++;
			while(i<arr.length && arr[i]!=' ') i++;
		}
		return count;
		
	}
	public static void main(String[] args) {
		String s=", , , ,        a, eaefa";
		System.out.println(countSegment(s));
	}

}
