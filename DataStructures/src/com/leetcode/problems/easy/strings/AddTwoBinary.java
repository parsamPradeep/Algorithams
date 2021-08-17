package com.leetcode.problems.easy.strings;

import java.math.BigInteger;

/*
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddTwoBinary {
	public static String addBinry(String a, String b) {
		int p1=a.length()-1;
		int p2=a.length()-1;
		String res="";
		int sum=0;
		int carry=0;
		while(p1>=0 && p2>=0) {
			sum=((a.charAt(p1)-'0')+(b.charAt(p2)-'0')+carry)%2;
			res=sum+res;
			carry=((a.charAt(p1)-'0')+(b.charAt(p2)-'0')+carry)/2;
			p1--;
			p2--;
			
		}
		if(carry==1)
			res=carry+res;
		return res;
	}
	public static String addBinary(String a, String b) {
		BigInteger aa = new BigInteger(a, 2);
		BigInteger bb = new BigInteger(b, 2);
		BigInteger ans = aa.add(bb);
		String res = ans.toString(2);
		return res;

	}

	public static void main(String[] args) {
		String a="1010";
		String b="1011";
		System.out.println(addBinry(a, b));

	}

}
