package com.leetcode.card.linkedlist;

public class EReverseALinkedList {
	public static class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
		}
	}
	public Node reverseList(Node head) {
        if(head == null)
            return null;
        Node root=head.next;
        Node ptr=head;
        while(root!=null){
            ptr.next=root.next;
            root.next=head;
            head=root;
            root=ptr.next;
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
