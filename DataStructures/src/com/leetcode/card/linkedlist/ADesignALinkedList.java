package com.leetcode.card.linkedlist;

public class ADesignALinkedList {
	static Node head;
	static int N=0;
	public static class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
		}
	}
	public static int get(int index) {
		if(index<0 || index>=N)
			return -1;
		Node tmp=head;
		int counter=0;
		while(counter!=index) {
			tmp=tmp.next;
			counter++;
		}
		return tmp.val;
	}
	public static void addAtHead(int val) {
		Node node=new Node(val);
		node.next=head;
		head=node;
		N++;
	}
	public static void addAtTail(int val) {
		if(head==null || N==0) {
			addAtHead(val);
			return;
		}
		Node node=new Node(val);
		Node tmp=head;
		while(tmp.next!=null)
			tmp=tmp.next;
		tmp.next=node;
		N++;
	}
	
	public static void addAtIndex(int val, int index) {
		if(index<0||index>N)
			return;
		if(index==N) {
			addAtTail(val);
			return;
		}
		if(index>N)
			return;
		if(index==0) {
			addAtHead(val);
			return;
		}
		Node tmp=head;
		Node node=new Node(val);
		int counter =0;
		while(counter!=(index-1)) {
			tmp=tmp.next;
			counter++;
		}
		node.next=tmp.next;
		tmp.next=node;
		N++;
	}
	public static void deleteAt(int index) {
		if(index<0 || index >= N)
			return ;
		if(index==0 && head != null) {
			head=head.next;
			N--;
			return;
		}
		Node pre=null;
		Node tmp=head;
		int counter=0;
		while(counter!=index) {
			pre=tmp;
			tmp=tmp.next;
			counter++;
		}
		pre.next=tmp.next;
		N--;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
