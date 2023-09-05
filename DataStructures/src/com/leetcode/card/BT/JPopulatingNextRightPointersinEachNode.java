package com.leetcode.card.BT;

import java.util.LinkedList;
import java.util.Queue;

public class JPopulatingNextRightPointersinEachNode {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.next=next;
		}
	}
	//Approach - 1
	public TreeNode connect(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        root.next=null;
        int i=1;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while(temp.size()>0 || queue.size()>0){
            int count=0;
            while(temp.size()>0){
            	TreeNode currNode=temp.remove();
                if(currNode.left!=null){
                    queue.offer(currNode.left);
                    count++;
                }
                if(currNode.right!=null){
                    queue.offer(currNode.right);
                    count++;
                }
            }
            while(count==Math.pow(2,i) && queue.size()>0){
            	TreeNode currNode=queue.remove();
                temp.offer(currNode);
                if(queue.peek() !=null){
                    currNode.next=queue.peek();
                }
            }
            i++;
            count=0;
          }
        return root;
    }
	
	//Approach - 2
	public TreeNode connect2(TreeNode root) {
        if(root==null) return root;
        TreeNode pre = root;
        TreeNode curr=null;
        while(pre.left!=null){
            curr=pre;
            while(curr!=null){
                curr.left.next=curr.right;
                if(curr.next!=null) curr.right.next=curr.next.left;
                curr=curr.next;
            }
            pre=pre.left;
        }
        return root;
    }
	
	//Approch - 3 
	    public void connect3(TreeNode root) {
	        if(root == null || root.left == null) return;
	        connectNodes(root.left, root.right);
	    }
	    
	    public void connectNodes(TreeNode node1, TreeNode node2) {
	        node1.next = node2;
	        if(node1.left != null) {
	            connectNodes(node1.right, node2.left);
	            connectNodes(node1.left, node1.right);
	            connectNodes(node2.left, node2.right);
	        }
	    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
