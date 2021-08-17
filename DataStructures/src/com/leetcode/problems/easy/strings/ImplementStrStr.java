package com.leetcode.problems.easy.strings;
/*
Return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.
Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 */
public class ImplementStrStr {
	
	 public static int strStr(String haystack, String needle) {
	        if(needle==null||needle.equals(""))
	            return 0;
	        return haystack.indexOf(needle);
	    }
	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		int res=strStr(haystack, needle);
		System.out.println(res);
	}

}
