package com.leetcode.card.BST;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/validate-binary-search-tree/solutions/32112/learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution/
import java.util.Stack;

public class ValidBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

// Approach - 1
	public static boolean validBST(TreeNode root) {
		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val)
				return false;
			pre = root;
			root = root.right;
		}
		return true;
	}

// Approach - 2
	private boolean isValid = true;
	private TreeNode pre = null;

	public boolean isValidBST2(TreeNode root) {
		helper(root);
		return isValid;
	}

	private void helper(TreeNode root) {
		if (root == null)
			return;
		helper(root.left);
		if (pre != null && pre.val >= root.val) {
			isValid = false;
			return;
		}
		pre = root;
		helper(root.right);
	}
	
// Approach - 3
//1.	Do an inorder traversal and store elements in an array.
//2.	check if array is sorted

	List<Integer> list = new ArrayList<Integer>();

	public boolean isValidBST3(TreeNode root) {
		inOrder(root);
		return isSortedArray();
	}

	private boolean isSortedArray() {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) >= list.get(i + 1)) {
				return false;
			}
		}
        
		return true;
	}

	private void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 5;
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(validBST(root));

	}

}
