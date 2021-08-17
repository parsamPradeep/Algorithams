package com.leetcode.problems.easy.strings;
/*
 Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
	 public static String longestCommonPrefix(String[] strs) {
	        String res="";
	        if(strs.length==0||strs==null)
	            return res;
	        for(int i=0;i<strs[0].length();i++){
	            for(int j=1;j<strs.length;j++){
	                if(i >= strs[j].length() ||strs[0].charAt(i)!=strs[j].charAt(i))
	                    return res;
	            }
	            res+=strs[0].charAt(i);
	        }
	        return res;
	    }
	public static void main(String[] args) {
	String arr[]={"cir","car"};
	String res=longestCommonPrefix(arr);
	System.out.println(res);

	}

}
