package com.strivers.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import static java.util.stream.Collectors.*;

import java.math.BigInteger;

public class Rough {
	public static int evaluatePostfix(String[] exp) {
		// Write your code here.
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<exp.length;i++){
			String ch=exp[i];
			if(Character.isDigit(ch.toCharArray()[0])){
				st.push(Integer.parseInt(ch));
			}else{
				int val1=st.pop();
				int val2=st.pop();
				switch(ch){
					case "+":
						st.push(val1+val2);
					case "-":
						st.push(val1-val2);
					case "/":
						st.push(val1/val2);
					case "*":
						st.push(val1*val2);
				}
			}
		}
		return st.pop();
	}

	public static void main(String args[]) {

	  int height[]={10, 20, 30, 10};
	  int n=4;
	String str[]= {"2", "3", "1", "*", "+", "9", "-"};
	System.out.println(evaluatePostfix(str));
	}

}
