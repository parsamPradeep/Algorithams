package com.leetcode.card.BT;

import java.util.Stack;

public class GPathSum {
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
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && targetSum - root.val == 0)
			return true;
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}

// Approach - 2
	public boolean hasPathSum2(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		Stack<TreeNode> path = new Stack<>();
		path.push(root);
		while (!path.isEmpty()) {
			TreeNode tempNode = path.pop();
			if (tempNode.left == null && tempNode.right == null) {
				if (tempNode.val == targetSum)
					return true;
			} else {
				if (tempNode.left != null) {
					TreeNode tempLeft = tempNode.left;
					tempLeft.val = tempLeft.val + tempNode.val;
					path.push(tempLeft);
				}
				if (tempNode.right != null) {
					TreeNode tempRight = tempNode.right;
					tempRight.val = tempRight.val + tempNode.val;
					path.push(tempRight);
				}
			}
		}
		return false;
	}

// Approach - 3
	boolean isFound = false;

	public boolean hasPathSum3(TreeNode root, int targetSum) {
		helper(root, targetSum);
		return isFound;
	}

	public void helper(TreeNode root, int target) {
		if (root == null)
			return;
		if ((root.left == null && root.right == null) && target - root.val == 0)
			isFound = true;
		helper(root.left, target - root.val);
		helper(root.right, target - root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
