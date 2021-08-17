package com.leetcode.problems.easy.strings;

public class ReverseStringI {
	public static char[] reverseString(char[] s) {
        int mid=s.length/2;
        int last=s.length-1;
        for(int i=0;i<mid;i++){
            char temp=s[i];
            s[i]=s[last];
            s[last]=temp;
            last--;
            
        }
        return s;
    }
	public static void main(String[] args) {
		char a[]=new char[2];
		char s[]= {'h','l','l','o'};
		System.out.println(reverseString(s));

	}

}
