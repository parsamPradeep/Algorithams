package com.algorithams.one.week2;

import java.util.Scanner;

public class FixedArrayStackOfStrings {

	private int N = 0;
	private String s[];

	public FixedArrayStackOfStrings(int cpacity) {
		s = new String[cpacity];
	}
	public void push(String item) {
		s[N++]=item;
	}
	public String pop() {
		String item=s[--N];
		s[N]=null;
		return item;
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int capacity() {
		return N;
	}
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		FixedArrayStackOfStrings ss =new FixedArrayStackOfStrings(Integer.valueOf(args[0]));
		while(scanner.hasNext()) {
			String s=scanner.next();
			if(s.equals("-"))
				System.out.println(ss.pop());
			else
				ss.push(s);
		}
	}

}
//javac FixedArrayStackOfStrings.java
//java FixedArrayStackOfStrings cpacity < file.txt