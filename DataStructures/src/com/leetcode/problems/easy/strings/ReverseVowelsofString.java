package com.leetcode.problems.easy.strings;
/*
Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede
 */
public class ReverseVowelsofString {
	public static String reverseVowels(String s) {
		String vowels="aeiouAEIOU";
		if(s.length()==0||s==null)
			return s;
		int head=0,tail=s.length()-1;
		char str[]=s.toCharArray();
		while(head<=tail) {
			while(head<tail&&!vowels.contains(String.valueOf(str[head])))
				head++;
			while(head<tail&&!vowels.contains(String.valueOf(str[tail]))) 
				tail--;
			char temp=str[head];
			str[head]=str[tail];
			str[tail]=temp;
			head++;
			tail--;
		}
		return new String(str);
	}
	public static void main(String[] args) {
		String in="Hello";
		System.out.println(reverseVowels(in));

	}

}
