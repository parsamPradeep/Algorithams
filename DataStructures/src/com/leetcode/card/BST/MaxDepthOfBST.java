package com.leetcode.card.BST;

public class MaxDepthOfBST {
	Node root;
	static class Node{
		Node left;
		Node right;
		int val;
		Node(int val){
			this.val=val;
		}
	}
	public static int helper(Node root) {
		if(root==null)
			return 0;
		int left=helper(root.left);
		int right=helper(root.right);
		return Math.max(left, right)+1;
	}
	public static void main() {
		
	}

}
