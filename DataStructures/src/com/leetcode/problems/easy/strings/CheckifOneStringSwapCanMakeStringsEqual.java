package com.leetcode.problems.easy.strings;
/*
Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
Example 2:

Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.
Example 3:

Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
Example 4:

Input: s1 = "abcd", s2 = "dcba"
Output: false
 
 */
public class CheckifOneStringSwapCanMakeStringsEqual {
	public static boolean areAlmostEqual(String s1, String s2) {
        int count=0;
        if(s1.length()!=s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();
        for(int i=0;i<s1.length();i++){
            if(!s2.contains(String.valueOf(s1.charAt(i))))
                return false;
            else if(ch1[i]!=ch2[i]){
                    ch1[i]=ch2[i];
                    count++;    
            }
            if(count==2){
                s1=new String(ch1);
                if(s1.equals(s2))
                    return true;
                else 
                    return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		String s1="attack";
		String s2="defend";
		System.out.println(areAlmostEqual(s1, s2));

	}

}
