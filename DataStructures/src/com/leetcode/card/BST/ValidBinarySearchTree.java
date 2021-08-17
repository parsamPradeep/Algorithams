package com.leetcode.card.BST;

import java.util.Stack;

public class ValidBinarySearchTree {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
	}
	public static boolean validBST(TreeNode root) {
		TreeNode pre=null;
		Stack<TreeNode> stack=new Stack<>();
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			if(pre!=null && root.val<=pre.val)
				return false;
			pre=root;
			root=root.right;
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode();
		root.val=5;
		root.left=new TreeNode(1);
		root.right=new TreeNode(4);
		root.right.left=new TreeNode(3);
		root.right.right=new TreeNode(6);
		System.out.println(validBST(root));

	}

}
