package com.leetcode.problems.medium.strings;

public class LongestPalindromicSubstring {
	static int resultStart=0;
	static int resultLength=0;
	public static String longestPalindrom(String s) {
		if(s.length()<2)
			return s;
		for(int start=0;start<s.length();start++) {
			expandRange(s,start,start);
			expandRange(s,start,start+1);
		}
	return s.substring(resultStart,resultStart+resultLength);
	}
	public static void expandRange(String s,int begin, int end) {
		while(begin>=0 && end<s.length() && s.charAt(begin)==s.charAt(end)) {
			begin--;
			end++;
		}
		if(resultLength<end-begin-1) {
			resultStart=begin+1;
			resultLength=end-begin-1;
		}
	}
	public static void main(String[] args) {
		String s="abcabcbb";
		System.out.println(longestPalindrom(s));

	}

}
