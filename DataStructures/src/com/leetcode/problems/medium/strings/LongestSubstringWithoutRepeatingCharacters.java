package com.leetcode.problems.medium.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static boolean isAllUnique(String s, int start, int end) {
		Set<Character> set= new HashSet<Character>();
		for(int i=start;i<end;i++) {
			Character ch=s.charAt(i);
			if(set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}
	
	// Approach - 1 with O(n3)
	public static int lengthOfLongestSubstring1(String s) {
		int n=s.length();
		int res=0;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(isAllUnique(s,i,j))
					res=Math.max(res, j-i);
		return res;
	}
	
	// Approach - 2 with O(n)
	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<Character>();
		int i = 0, j = 0, ans = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				ans= Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		for(int r=i;r<j;r++)
			System.out.println(s.charAt(r));
		return ans;
	}
	
	// Approach - 3 
	public static int lengthOfLongestSubstring3(String s) {
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		int n=s.length();
		int ans=0;
		for(int i=0,j=0;j<n;j++) {
			if(map.containsKey(s.charAt(j))) {
				i=Math.max(map.get(s.charAt(j)), i);
			}
			ans=Math.max(ans, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return ans;
	} 
	
	// Approach - 4
	public static int lengthOfLongestSubString4(String s) {
		int max=1;
		int ptr=0;
		for(int i=1;i<s.length();i++) {
			int index=s.indexOf(s.charAt(i),ptr);
			if(index<i) {
				ptr=index+1;
			}
			max=Math.max(max, i-ptr+1);
		}
		return max;
	}

	public static void main(String[] args) {
		String s="pwwkew";
		int res=lengthOfLongestSubstring2(s);
		System.out.println(res);

	}

}
