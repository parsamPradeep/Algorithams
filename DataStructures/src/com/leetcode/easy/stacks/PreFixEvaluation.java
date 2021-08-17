package com.leetcode.easy.stacks;

import java.util.Stack;

public class PreFixEvaluation {
	public static int preFixEvaluation(String s) {
		Stack<Integer> stack=new Stack<>();
		for(int i=s.length()-1;i>=0;i--) {
			char c=s.charAt(i);
			if(Character.isDigit(c))
				stack.push(c-'0');
			else {
				int val1=stack.pop();
				int val2=stack.pop();
				switch(c) {
				case '+':
					stack.push(val1+val2);
					break;
				case '-':
					stack.push(val1-val2);
					break;
				case '*':
					stack.push(val1*val2);
					break;
				case '/':
					stack.push(val1/val2);
					break;
					
				}
			}
			
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		 String exprsn = "+9*26";
		 System.out.println(preFixEvaluation(exprsn));
		

	}

}
