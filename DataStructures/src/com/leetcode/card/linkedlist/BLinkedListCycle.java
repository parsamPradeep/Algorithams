package com.leetcode.card.linkedlist;

public class BLinkedListCycle {
	static Node head;

	public static class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
		}
	}
	public static boolean hasCycle(Node head) {
		Node walker=head;
		Node runner=head;
		while(runner.next!=null && runner.next.next!=null) {
			walker=runner.next;
			runner=runner.next.next;
			if(walker==runner)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
