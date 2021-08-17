package com.leetcode.problems.easy.strings;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}
	public static void main(String[] args) {
		String s=" ";
		System.out.println(lengthOfLastWord(s));
		 s=s.replace(" ","").replace(",","").replace(":","");
	}

}
