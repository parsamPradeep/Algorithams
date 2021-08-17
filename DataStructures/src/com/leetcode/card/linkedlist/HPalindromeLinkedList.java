package com.leetcode.card.linkedlist;

public class HPalindromeLinkedList {
	public static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	// Approach - 1 not efficient
	static String rev = "";
	static String str = "";

	public static boolean isPalindrome(Node head) {
		reverseLList(head);
		return rev.equals(str);
	}

	public static void reverseLList(Node head) {
		if (head == null)
			return;
		str += head.val;
		reverseLList(head.next);
		rev += head.val;
	}

	// Approach - 2
	static Node ref = null;

	public static boolean isPalindrome2(Node head) {
		ref = head;
		return check(head);
	}

	public static boolean check(Node head) {
		if (head == null)
			return true;
		boolean ans = check(head.next);
		boolean check = ref.next == head.next ? true : false;
		ref = ref.next;
		return ans && check;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		System.out.println(isPalindrome(head));

	}

}
