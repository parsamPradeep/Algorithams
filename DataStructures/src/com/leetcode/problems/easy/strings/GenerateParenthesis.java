package com.leetcode.problems.easy.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	  public static List<String> generateParenthesis(int n) {
	        List<String> res = new ArrayList<String>();
	        generateByRecc(1, 0, "(", res, n);
	        return res;
	        
	    }
	    public static void generateByRecc(int open, int close, String s, List<String> res, int n){
	           if(s.length() == n*2){
	               res.add(s);
	               return;
	           }
	            
	            if(open < n)
	                generateByRecc(open+1, close, s+"(", res, n);
	            if(close < open)
	                generateByRecc(open, close+1, s+")",res, n);
	        }
	    public static void main(String[] args) {
		List<String> res= generateParenthesis(3);
		System.out.println(res);
	}

}
