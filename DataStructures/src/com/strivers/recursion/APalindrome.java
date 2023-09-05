package com.strivers.recursion;

public class APalindrome {
	
	public boolean isPalindrome(String str, int i) {
		if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
		if(i>=str.length()/2) return true;
		return isPalindrome(str, i+1);
	}
	// TC:- O(n) SC:- O(n) internal stack 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		APalindrome obj = new APalindrome();
		System.out.println(obj.isPalindrome("madfffam", 0));
	}

}
