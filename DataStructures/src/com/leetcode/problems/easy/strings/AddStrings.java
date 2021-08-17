package com.leetcode.problems.easy.strings;

/*
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

	public static String addString(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;

		StringBuilder s = new StringBuilder();
		int carray = 0;
		while (i >= 0 || j >= 0 || carray > 0) {
			int n = 0;
			int m = 0;
			if (i >= 0) {
				n = num1.charAt(i) - '0';
				i--;
			}
			if (j >= 0) {
				m = num2.charAt(j) - '0';
				j--;
			}
			int num = (n + m + carray) % 10;
			carray = (n + m + carray) >= 10 ? 1 : 0;
			s.append(num);
		}
		return s.reverse().toString();
	}

	public static void main(String[] args) {
		String s1 = "188";
		String s2 = "199";
		System.out.println(addString(s1, s2));

	}

}
