package com.leetcode.problems.easy.strings;
/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
public class CanConstruct {
	//Approach - 1
	public static  boolean canConstruct1(String ransomNote, String magazine) {
        char s1[]=ransomNote.toCharArray();
        char s2[]=magazine.toCharArray();
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s2.length;j++){
                if(s1[i]==s2[j]){
                    s2[j]=' ';
                    s1[i]=' ';
                    break;
                }
            }
                
        }
        return (new String(s1).trim().length()>0)?false:true;
       
    }
	//Approach - 2 recommended
	 public static boolean canConstruct2(String ransomNote, String magazine) {
		 int[] hash = new int[26];
	        for (char c : magazine.toCharArray())
	            hash[c-'a']+=1;
	        for (char c : ransomNote.toCharArray())
	            if ((hash[c-'a']-1) < 0) 
	                return false;
             else
                hash[c-'a']-=1; 
         
	        return true;
	    }
	public static void main(String[] args) {
		String a="aaa";
		String b="aab";
		char c[]= {'1','2','3','4'};
		for(char i:c)
			System.out.println((int)i);
		System.out.println(c[2]+c[3]);
		System.out.println(canConstruct2(a,b));

	}

}
