package com.algorithams.one.week2;

import java.util.Scanner;


public class GenericLinkedStackOfStrings<Item> {
	
	private Node first=null;
	private int size=0;
	private class Node {
		Item item;
		Node next;
	}
	
	public void push(Item item) {
		Node oldfirst=first;
		first=new Node();
		first.next=oldfirst;
		first.item=item;
		size++;
	}
	public Item pop() {
		Item item=first.item;
		first=first.next;
		size--;
		return item;
	}
	public boolean isEmpty() {
		return first==null;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		GenericLinkedStackOfStrings<String> ss =new GenericLinkedStackOfStrings<String>();
		while(scanner.hasNext()) {
			String s=scanner.next();
			if(s.equals("-"))
				System.out.println(ss.pop());
			else
				ss.push(s);
		}
	}
}
