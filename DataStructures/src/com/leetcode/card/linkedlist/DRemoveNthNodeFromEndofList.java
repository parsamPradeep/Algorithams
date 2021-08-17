package com.leetcode.card.linkedlist;

import java.util.Stack;

public class DRemoveNthNodeFromEndofList {
	public static class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
		}
	}
	public static Node removeNthFromEnd(Node head, int n) {
        if(head.next==null)
            return null;
        Node x=head;
        Node pre=null;
        Stack<Node> stack=new Stack<Node>();
        int i=0;
        while(x!=null){
            stack.push(x);
            x=x.next;
        }
        while(i<n){
            x=stack.pop();
            i++;
        }
        if(!stack.isEmpty()){
            pre=stack.pop();
            pre.next=x.next;
        }else{
            head=x.next;
        }
        
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
