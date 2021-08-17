package com.leetcode.card.linkedlist;

public class FRemoveLinkedListElements {
	public static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public static Node removeElements(Node head, int val) {
		if (head == null)
			return null;

		while (head.val == val && head.next != null)
			head = head.next;

		if (head.val == val)
			head = head.next;

		if (head == null)
			return null;
		Node root = head;

		while (root.next != null) {
			Node pre = root;
			root = root.next;
			if (root.val == val) {
				pre.next = root.next;
				root = pre;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
