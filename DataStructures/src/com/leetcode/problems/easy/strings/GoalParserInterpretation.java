package com.leetcode.problems.easy.strings;
/*
Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".
Example 2:

Input: command = "G()()()()(al)"
Output: "Gooooal"
Example 3:

Input: command = "(al)G(al)()()G"
Output: "alGalooG"
 */
public class GoalParserInterpretation {
	 public static  String interpret(String command) {
	        StringBuilder res = new StringBuilder(command.length());
	        for(int i=0;i<command.length();i++){
	            if(command.charAt(i)=='G')
	                res.append('G');
	            if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
	                res.append('o');
	                i++;
	            }
	                
	            if(command.charAt(i)=='(' && command.charAt(i+1)=='a'){
	                res.append("al");
	                i+=3;
	            }
	                
	        }
	        return res.toString();
	    }
	public static void main(String[] args) {
		String command="(al)G(al)()()G";
		System.out.println(interpret(command));

	}

}
