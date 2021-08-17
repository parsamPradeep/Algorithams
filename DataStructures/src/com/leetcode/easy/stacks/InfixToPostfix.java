package com.leetcode.easy.stacks;

import java.util.Stack;

public class InfixToPostfix {
	public static int prec(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
			
		}
		return -1;
	}
	
	public static String infixToPostfix(String s) {
		String res="";
		Stack<Character> stack=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(Character.isLetterOrDigit(c))
				res+=c;
			else if(c=='(') {
				stack.push('(');
			}else if(c==')') {
				while(!stack.isEmpty() && stack.peek()!='(') 
					res+=stack.pop();
				stack.pop();
			}else {
				while(!stack.isEmpty() && prec(c)<=prec(stack.peek())) {
					res+=stack.pop();
				}
				stack.push(c);
			}
			
		}
		while(!stack.isEmpty()) {
			res+=stack.pop();
		}
		return res;
	}
	public static void main(String[] args) {
		String s="a+b*(c^d-e)^(f+g*h)-i"; 
		System.out.println(infixToPostfix(s));

	}

}
