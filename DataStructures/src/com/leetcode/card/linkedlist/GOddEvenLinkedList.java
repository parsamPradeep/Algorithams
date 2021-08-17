package com.leetcode.card.linkedlist;

public class GOddEvenLinkedList {
	public static class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
		}
	}
	public Node oddEven(Node head) {
		Node odd=head;
		Node evenHead=head.next;
		Node even=evenHead;
		while(even!=null && even.next!=null) {
			odd.next=even.next;
			odd=odd.next;
			even.next=odd.next;
			even=even.next;
		}
		odd.next=evenHead;
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
