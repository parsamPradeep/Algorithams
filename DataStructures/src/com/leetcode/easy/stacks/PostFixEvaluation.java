package com.leetcode.easy.stacks;

import java.util.Stack;

public class PostFixEvaluation {
	public static int postfixEvaluation(String s) {
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(Character.isDigit(c))
				stack.push(c-'0');
			else {
				int val1=stack.pop();
				int val2=stack.pop();
				switch(c) {
				case '+':
					stack.push(val2+val1);
					break;
				case '-':
					stack.push(val2-val1);
					break;
				case '*':
					stack.push(val2*val1);
					break;
				case '/':
					stack.push(val2/val1);
					break;
				}
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		String exp="3915+4911/+869-8143+/-"; 
		System.out.println(postfixEvaluation(exp));

	}

}
