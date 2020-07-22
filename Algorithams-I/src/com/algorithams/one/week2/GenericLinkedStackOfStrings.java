package com.algorithams.one.week2;

import java.util.Iterator;
import java.util.Scanner;


public class GenericLinkedStackOfStrings<Item> implements Iterable<Item> {
	
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
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	public class ListIterator implements Iterator<Item>{
		private Node current =first;
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current=current.next;
			return item;
		}
		
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
