package com.linkedlist;

public class Solution {
	  public static void reverseString(char[] s) {
	        int mid=s.length/2;
	        int last=s.length-1;
	        for(int i=0;i<mid;i++){
	            char temp=s[i];
	            s[i]=s[last];
	            s[last]=temp;
	            last--;
	            
	        }
	    }
	  public static void main(String[] args) {
			char arr[]= {'h','e','l','l','o'};
			reverseString(arr);
			for(char i:arr)
			System.out.println(i);

		}
}
