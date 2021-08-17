package com.leetcode.card.recurssion1;

public class AReverseAString {
	
	public static void reverseString(char s[]) {
		helper(s,0,s.length-1);
	}
	
	public static void helper(char s[],int left, int right) {
		if (left>=right)
			return;
		char temp=s[left];
		s[left]=s[right];
		s[right]=temp;
		left++;
		right--;
		helper(s,left,right);
		
	}
	 public static void main(String[] args) {
			char arr[]= {'h','e','l','l','o'};
			reverseString(arr);
			for(char i:arr)
			System.out.println(i);

		}

}
