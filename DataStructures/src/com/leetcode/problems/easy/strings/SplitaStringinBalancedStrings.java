package com.leetcode.problems.easy.strings;
/*
Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 */
public class SplitaStringinBalancedStrings {
	public static int balancedStringSplit(String s) {
        int countR=0,countL=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(countR==countL){
                res++;
                countR=0;
                countL=0;
            }

            if(s.charAt(i)=='L')
                countL++;
            else
                countR++;  
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String in="RLLLLRRRLR";
		System.out.println(balancedStringSplit(in));
		

	}

}
