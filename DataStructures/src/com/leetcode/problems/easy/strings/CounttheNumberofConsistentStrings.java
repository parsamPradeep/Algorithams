package com.leetcode.problems.easy.strings;
/*
You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

 

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.
 */
public class CounttheNumberofConsistentStrings {
	 public static int countConsistentStrings(String allowed, String[] words) {
	        int res=0;
	        
	        for(int i=0;i<words.length;i++){
	            String word=words[i];
	            boolean addTores=false;
	            for(int j=0;j<word.length();j++){
	                if(allowed.contains(String.valueOf(word.charAt(j)))){
	                    addTores=true;
	                }else{
	                    addTores=false;
	                    break;
	                }
	            }
	            if(addTores)
	                res++;
	        }
	        return res;
	    }
	public static void main(String[] args) {
		String allowed = "ab";
		String words[] = {"ad","bd","aaab","baa","badab"};
		System.out.println(countConsistentStrings(allowed, words));

	}

}
