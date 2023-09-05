package com.leetcode.card.BT;

public class EMaxDepthOfBT {
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

	static int total = 0;

	public static int maxDepth(TreeNode root) {
		return helper(root, 1);
	}

	public static int helper(TreeNode root, int level) {
		if (root == null)
			return 0;
		total = Math.max(total, level);
		helper(root.left, level + 1);
		helper(root.right, level + 1);
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
