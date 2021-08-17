package com.leetcode.card.linkedlist;

public class KMergeTwoSortedLists {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val=val;
		}
	}
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null && l2==null)
	            return null;
	        if(l1==null && l2!=null)
	            return l2;
	        if(l1!=null && l2==null)
	            return l1;
	        ListNode head=null;
	        if(l1.val<l2.val){
	            head=new ListNode(l1.val);
	            l1=l1.next;
	        }
	        else{
	            head=new ListNode(l2.val);
	            l2=l2.next;
	        }
	        ListNode tmp=head;
	        while(l1!=null && l2!=null){
	            if(l1.val<l2.val){
	            tmp.next=new ListNode(l1.val);
	            l1=l1.next;
	        }
	        else{
	            tmp.next=new ListNode(l2.val);
	            l2=l2.next;
	        }
	          tmp=tmp.next;      
	        }
	        while(l1!=null){
	            tmp.next=new ListNode(l1.val);
	            tmp=tmp.next;
	            l1=l1.next;
	        }
	         while(l2!=null){
	            tmp.next=new ListNode(l2.val);
	             tmp=tmp.next;
	             l2=l2.next;
	         }
	        return head;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
