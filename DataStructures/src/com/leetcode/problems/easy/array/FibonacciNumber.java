package com.leetcode.problems.easy.array;
/*
Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class FibonacciNumber {
	
	// Approach - 1 Iterative
	 public static int fib1(int n) {
	        if(n<=1)
	            return n;

	        int p1=0;
	        int p2=1;
	        int num=0;
	        for(int i=0;i<n-1;i++){
	            int tmp=p1+p2;
	            p1=p2;
	            p2=tmp;
	            
	            num=tmp;
	        }
	        return num;
	    }
	 
	 // Approach -2 Reccursion
	 public static int fib2(int n) {
		 if(n<=1)
			 return n;
		 return fib2(n-1)+fib2(n-2);
	 }
	public static void main(String[] args) {
		int n=3;
		System.out.println(fib2(n));

	}

}
