package com.leetcode.problems.easy.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	// Approach - 2
	public static int romanToInteger2(String s) {
		int sum=0;
		if(s.indexOf("IV")!=-1)
			sum-=2;
		if(s.indexOf("IX")!=-1)
			sum-=2;
		if(s.indexOf("XL")!=-1)
			sum-=20;
		if(s.indexOf("XC")!=-1)
			sum-=20;
		if(s.indexOf("CD")!=-1)
			sum-=200;
		if(s.indexOf("CM")!=-1)
			sum-=200;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='M')
				sum+=1000;
			if(s.charAt(i)=='D')
				sum+=500;
			if(s.charAt(i)=='C')
				sum+=100;
			if(s.charAt(i)=='L')
				sum+=50;
			if(s.charAt(i)=='X')
				sum+=10;
			if(s.charAt(i)=='V')
				sum+=5;
			if(s.charAt(i)=='I')
				sum+=1;
		}
		return sum;
	}
	
	// Approach - 1
	public static int romanToInteger1(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && (map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))) {
				res += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
			} else {
				res += map.get(s.charAt(i));
			}
		}
		return res;
	}

	public static void main(String[] args) {
	String s="XL";
	int res=romanToInteger2(s);
	System.out.println(res);

	}

}
