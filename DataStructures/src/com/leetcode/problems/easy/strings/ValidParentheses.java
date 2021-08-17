package com.leetcode.problems.easy.strings;
/*
 Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 */
import java.util.Stack;

public class ValidParentheses {
	 public static boolean isValid(String s) {

	        Stack<Character> stack=new Stack<Character>();

	        for(int i=0;i<s.length();i++){
	           if(stack.empty()){
	               stack.push(s.charAt(i));
	           }else{
	               char top=stack.peek();
	               char cur=s.charAt(i);
	               if(cur-top==1||cur-top==2){
	                   stack.pop();
	               }else{
	                   stack.push(s.charAt(i));
	               }
	           }
	        }
	        return stack.empty()?true:false;
	    }
	public static void main(String[] args) {
		String s = "()[]{}";
		boolean res=isValid(s);
		System.out.println(res);

	}

}
