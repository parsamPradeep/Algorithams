package com.leetcode.problems.easy.strings;

/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False
 */
public class DetectCapital {
	// Approach - 2
	 public static boolean detectCapitalUse2(String word) {
	        int caps = 0;
	        for (int i = 0; i < word.length(); i++) {
	            if (Character.isUpperCase(word.charAt(i))){
	                caps++;
	            }
	        }
	        if (caps == word.length() || caps == 0) return true;
	        return caps == 1 && Character.isUpperCase(word.charAt(0));
	    }
	 
	 // Approach - 1
	public static boolean detectCapitalUse1(String word) {
		if (word.length() == 1)
			return true;
		char a = word.charAt(0);
		char b = word.charAt(1);
		if (a >= 97 && b <= 90)
			return false;
		for (int i = 2; i < word.length(); i++) {
			if ((a >= 97 && a <= 122) && (b >= 97 && b <= 122) && (word.charAt(i) < 97 || word.charAt(i) > 122))
				return false;

			if ((a >= 65 && a <= 90) && (b >= 65 && b <= 90) && (word.charAt(i) < 65 || word.charAt(i) > 90))
				return false;

			if ((a >= 65 && a <= 90) && (b >= 97 && b <= 122) && (word.charAt(i) < 97 || word.charAt(i) > 122))
				return false;

		}
		return true;
	}

	public static void main(String[] args) {
		String s="leetcode";
		System.out.println(detectCapitalUse1(s));
		String s1="leetCode";
		System.out.println(detectCapitalUse2(s1));
				

	}

}
