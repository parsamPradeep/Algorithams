package com.leetcode.card.linkedlist;

public class JFlattenMultiLevelLinkedList {
	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		Node(int val) {
			this.val = val;
		}
	}

	public static Node flatten(Node head) {
		if (head == null)
			return null;
		Node root = head;
		Node rootChild = null;
		while (root.next != null) {
			if (root.child != null) {
				rootChild = root.child;
				while (rootChild.next != null) {
					rootChild = rootChild.next;
				}
				root.child.prev = root;
				if (root.next != null) {
					rootChild.next = root.next;
					root.next.prev = rootChild;
				}
				root.next = root.child;
			}
			root = root.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.child = new Node(7);
		head.next.next.child.next = new Node(8);
		head.next.next.child.next.child = new Node(11);
		head.next.next.child.next.child.next = new Node(12);
		head.next.next.child.next.next = new Node(9);
		head.next.next.child.next.next.next = new Node(10);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		

		Node root=flatten(head);
		
		while(root!=null) {
			System.out.println(root.val);
			root=root.next;
		}
	}
}
