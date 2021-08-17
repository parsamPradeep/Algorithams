package com.leetcode.problems.easy.strings;
/*
Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
 */
public class MergeStringsAlternately {
	// Approach - 1
	 public static String mergeAlternately(String word1, String word2) {
	        int i=0,j=0;
	        int n=word1.length();
	        int m=word2.length();
	        char res[]=new char[n+m];
	        for(int k=0;k<(n+m);k++){
	            if(i<n && j<m){
	                res[k++]=word1.charAt(i);
	                i++;
	            }else if(i<n){
	                res[k]=word1.charAt(i);
	                i++;
	            }
	            if(j<m){
	                res[k]=word2.charAt(j);
	                j++;
	            }
	        }
	        return new String(res);
	    }
	public static void main(String[] args) {
		String word1 = "ab";
		String word2 = "pqrs";
		System.out.println(mergeAlternately(word1, word2));
		StringBuilder str=new StringBuilder();
		

	}

}
