package com.leetcode.problems.easy.strings;

public class RepeatedSubstringPattern {
	// Approach - 1
	public static boolean repeatedSubstringPattern1(String s) {
		int n = s.length();

		for (int i = n / 2; i >= 1; i--) {
			if (n % i == 0) {
				int c = n / i;
				String ss = s.substring(0, i);
				StringBuilder str = new StringBuilder();
				for (int j = 0; j < c; j++)
					str.append(ss);
				if (str.toString().equals(s))
					return true;
			}
		}
		return false;
	}
	
	//Approach - 2
	public static boolean repeatedSubstringPattern2(String s) {
		int inx=(s+s).indexOf(s,1);
		return inx<s.length();
	}

	public static void main(String[] args) {
		String s = "aba";
		System.out.println(repeatedSubstringPattern2(s));

	}

}
