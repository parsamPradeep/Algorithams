package com.leetcode.card.linkedlist;

public class IDesignADoubleLinkedList {
	 static int length=0;
	    static Node head=null;
	    class Node {
	        int val;
	        Node next,prev;
	        Node(int x) {
	            this.val = x;
	        }    
	    }
	    

	    
	    
	    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	    public int get(int index) {
	        if(index < 0 || index >= this.length) {
	            return -1;
	        }
	        else {
	            int counter = 0;
	            Node curr = head;
	            while(counter != (index)) {
	                curr = curr.next;
	                counter++;
	            }
	            return curr.val;
	        }
	        
	    }
	    
	    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	    public void addAtHead(int val) {
	        Node newNode = new Node(val);
	        newNode.next = this.head;
	       if(head !=null)
	        this.head.prev=newNode;
	        this.head = newNode;
	        this.length++;    
	    }
	    
	    /** Append a node of value val to the last element of the linked list. */
	    public void addAtTail(int val) {
	        if(this.length == 0) {
	            addAtHead(val);
	            return;
	        }
	        Node newNode = new Node(val);
	        Node temp = head;
	        while(temp.next != null) {
	            temp = temp.next;
	        }
	        temp.next = newNode;
	        newNode.prev=temp;
	        newNode.next = null;
	        this.length++;
	    }
	    
	    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	    public void addAtIndex(int index, int val) {
	        Node newNode = new Node(val);
	        Node temp = head;
	        int counter = 0;
	        if((index) == this.length) {
	            addAtTail(val);
	            return;
	        }
	        if(index > this.length) {
	            return;
	        }
	        if(index == 0){
	            addAtHead(val);
	            return;
	        }
	        while(counter != (index -1)) {
	            temp = temp.next;
	            counter++;
	        }
	        newNode.next = temp.next;
	        newNode.prev=temp;
	        temp.next = newNode;
	        this.length++;
	    }
	    
	    /** Delete the index-th node in the linked list, if the index is valid. */
	    public void deleteAtIndex(int index) {
	        if(index==0 && head!=null){
	            this.length--;
	            head=head.next;
	            if(head !=null)
	                head.prev=null;
	            return;
	        }
	        if(index < 0 || index >= this.length) {
	            return;
	        }
	        Node curr = head;
	        if(index == 0) {
	            head = curr.next;
	            if(head !=null)
	                head.prev=null;
	        }
	        else {
	                Node current = head;
	                Node pre = null;
	                int counter =0;
	                while(counter != index) {
	                    pre = current;
	                    current = current.next;
	                    counter++;
	                }
	            if(current!=null && pre!=null)
	                pre.next = current.next;
	            if(current.next!=null)
	                current.next.prev=pre;
	                this.length--;
	        }   
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
