package com.algorithams.one.week2;

import java.util.Scanner;

public class LinkedQueueOfStrings {
	private Node first = null;
	private int size = 0;
	private Node last = null;

	private class Node {
		String item;
		Node next;
	}

	public void enqueue(String item) {
		Node old_last = last;
		Node new_item = new Node();
		new_item.item = item;
		new_item.next = null;
		last = new_item;
		if (first == null)
			first = new_item;
		else
			old_last.next = last;
		size++;
	}

	public String dequeue() {
		String item = first.item;
		first = first.next;
		size--;
		if(first==null)
			last=null;
		return item;
	}

	public int capacity() {
		return size;
	}

	public boolean isEmplty() {
		return first == null;
	}

	public static void main(String[] args) {
		LinkedQueueOfStrings lq=new LinkedQueueOfStrings();
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()) {
			String s=scanner.next();
			if(s.equals("-"))
				System.out.println(lq.dequeue());
			else
				lq.enqueue(s);
		}

	}

}
