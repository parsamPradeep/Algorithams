package com.linkedlist;

import java.util.Scanner;

public class LikedList {
	Node head;
		static class Node{
			int data;
			Node next;
			Node(int d){
				data=d;
				next=null;
			}
		}
	public void append(int d) {
		Node new_node=new Node(d);
		if(head==null) {
			head=new_node;
			return;
		}
		Node last=head;
		while(last.next!=null) {
			last=last.next;
		}
		last.next=new_node;
		return;
		
	}
	public void push(int d) {
		Node new_node=new Node(d);
		
		new_node.next=head;	
		head=new_node;
		
	}
	public void insertAfter(Node node,int d) {
		if(node==null) {
			System.out.println("The givinn previous node cant be null");
			return;
		}
		Node new_node=new Node(d);
		new_node.next=node.next;
		node.next=new_node;
		
	}
	public void delete(int key) {
		if(head.data==key && head.next==null)
			head=null;
		if(head.data==key && head.next!=null)
			head=head.next;
		
		Node next_node=head,prev_node=null;
		while(next_node.data!=key && next_node.next!=null) {
			prev_node=next_node;
			next_node=next_node.next;
		}
		if(prev_node==null)
			return;
		else
			prev_node.next=next_node.next;
	}
	public void printList() {
		Node tnode=head;
		while(tnode!=null) {
			System.out.println("list data "+tnode.data);
			if(tnode.next!=null)
			tnode=tnode.next;
			else
			tnode=null;
		}
	}
	public static void main(String [] args) {
		LikedList llist=new LikedList();
		for(int i=0;i<i+1;i++) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please select the operation from menu");
		System.out.println(" 1. Append \n 2. Push\n 3. Inser After\n 4. Delete\n 5. Exit");
		int choice=scanner.nextInt();
		switch(choice){
			case 1:{
				System.out.println("enter the node data");
				int d=scanner.nextInt();
				llist.append(d);
				llist.printList();
				break;
			}
			case 2:{
				System.out.println("enter the node data");
				int d=scanner.nextInt();
				llist.push(d);
				llist.printList();
				break;
			}
			case 3:{
				System.out.println("enter the node data");
				int d=scanner.nextInt();
				llist.insertAfter(llist.head.next.next, d);
				llist.printList();
				break;
			}
			case 4:{
				System.out.println("enter the node data to be deleted");
				int key=scanner.nextInt();
				llist.delete(key);
				llist.printList();
				break;
			}
			default:
				break;
			
		}
		if(choice==5) {
			System.exit(1);;
		}
		}
		
		
	}
	

}
