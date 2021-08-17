package com.leetcode.card.linkedlist;

public class CIntersectionOfTwoLinkedList {

	public static class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
		}
	}
	public static Node findintersection(Node headA, Node headB) {
		if(headA==null || headB==null)
			return null;
		Node i=headA;
		Node j=headB;
		while(i!=j) {
			i=i==null?headB:i.next;
			j=j==null?headA:j.next;
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
