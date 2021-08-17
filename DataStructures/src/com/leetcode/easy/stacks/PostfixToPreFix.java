package com.leetcode.easy.stacks;

import java.util.Stack;

public class PostfixToPreFix {
	public static String postTopre(String s) {
		Stack<String> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(Character.isLetter(c))
				stack.push(c+"");
			else {
				String op1=stack.pop();
				String op2=stack.pop();
				stack.push(c+op2+op1);
			}
		}

	        return stack.pop();
	}
	public static void main(String[] args) {
		 String s = "ABC/-AK/L-*";
		 System.out.println(postTopre(s));

	}

}
