package com.leetcode.card.BST;

import java.util.ArrayList;

public class KthSmalllest {
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

	public static ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
		if (root == null)
			return arr;
		inorder(root.left, arr);
		arr.add(root.val);
		inorder(root.right, arr);
		return arr;
	}

	public static int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
		return nums.get(k);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 5;
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(kthSmallest(root, 2));

	}
}
