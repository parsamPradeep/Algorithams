package com.leetcode.easy.stacks;

import java.util.Stack;

public class PostfixToInfix {
	
	public static String postfixToInfix(String s) {
		Stack<String> stack=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(Character.isLetter(c))
				stack.push(c+"");
			else {
				String op1=stack.pop();
				String op2=stack.pop();
				stack.push("("+op1+c+op2+")");
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		String exp = "ab*c+"; 
		System.out.println(postfixToInfix(exp));

	}

}
