package com.leetcode.problems.easy.strings;
/*
 Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 */
public class FirstUniqCharInStr {
	 public static int firstUniqChar(String s) {
	        for(int i=0;i<s.length();i++){
	            if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i)))
	                return i;
	        }
	        return -1;
	    }
	public static void main(String[] args) {
		String s="leelcode";
		System.out.println(firstUniqChar(s));
	}

}
