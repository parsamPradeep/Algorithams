package com.leetcode.easy.stacks;

import java.util.Stack;

public class PrefixToPostfix {
	public static String preToPost(String s) {
		Stack<String> stack = new Stack<>();
		for(int i=s.length()-1;i>=0;i--) {
			char c=s.charAt(i);
			if(Character.isLetter(c))
				stack.push(c+"");
			else {
				String op1=stack.pop();
				String op2=stack.pop();
				stack.push(op1+op2+c);
			}
		}

	        return stack.pop();
	}
	public static void main(String[] args) {
		String s = "*-A/BC-/AKL";
		System.out.println(preToPost(s));

	}

}
