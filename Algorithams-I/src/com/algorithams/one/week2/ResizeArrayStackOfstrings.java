package com.algorithams.one.week2;

import java.util.Scanner;

public class ResizeArrayStackOfstrings {


	private int N = 0;
	private String s[];

	public ResizeArrayStackOfstrings(int cpacity) {
		s = new String[cpacity];
	}
	private void resize(int size) {
		String copy[]=new String[size];
		for(int i=0;i<N;i++)
			copy[i]=s[i];
		s=copy;
	}
	public void push(String item) {
		if(N==s.length)
			resize(s.length*2);
		s[N++]=item;
	}
	
	public String pop() {
		String item=s[--N];
		s[N]=null;
		if(N>0 && N==s.length/4)
			resize(s.length/2);
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
		ResizeArrayStackOfstrings ss =new ResizeArrayStackOfstrings(Integer.valueOf(args[0]));
		while(scanner.hasNext()) {
			String s=scanner.next();
			if(s.equals("-"))
				System.out.println(ss.pop());
			else
				ss.push(s);
		}
	}


}
