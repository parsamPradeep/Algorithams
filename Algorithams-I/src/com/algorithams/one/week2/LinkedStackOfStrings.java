package com.algorithams.one.week2;

import java.util.Scanner;

public class LinkedStackOfStrings {
	
	private Node first=null;
	private int size=0;
	private class Node {
		String item;
		Node next;
	}
	
	public void push(String s) {
		Node oldfirst=first;
		first=new Node();
		first.next=oldfirst;
		first.item=s;
		size++;
	}
	public String pop() {
		String item=first.item;
		first=first.next;
		size--;
		return item;
	}
	public boolean isEmpty() {
		return first==null;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		LinkedStackOfStrings ss =new LinkedStackOfStrings();
		while(scanner.hasNext()) {
			String s=scanner.next();
			if(s.equals("-"))
				System.out.println(ss.pop());
			else
				ss.push(s);
		}
	}

}

//javac LinkedStackOfStrings.java
//java LinkedStackOfStrings < file.txt