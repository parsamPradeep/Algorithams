package com.leetcode.card.BST;

public class MinDepthOgBST {
	Node root;

	static class Node {
		Node left;
		Node right;
		int val;

		Node(int val) {
			this.val = val;
		}
	}

	public static int helper(Node root) {
		if (root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		if (left == 0 || right == 0)
			return left + right + 1;
		return Math.min(left, right) + 1; 
	}

	public static void main() {

	}
}
