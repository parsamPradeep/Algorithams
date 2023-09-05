package com.leetcode.card.BST;

import java.util.Stack;

public class PathSum {
	static class TreeNode {
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
// Approach - 1
// By subtracting sum
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

// Approach - 2
//By adding to current node
	public static boolean hasPathSum2(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return root.val == targetSum;

		if (root.left != null)
			root.left.val += root.val;
		if (root.right != null)
			root.right.val += root.val;

		return (hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum));
	}

// Approach - 3 
// Iterative
	public static boolean hasPathSum3(TreeNode root, int targetSum) {
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

	public static void main(String[] args) {
		TreeNode root=new TreeNode();
		root.val=5;
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.left.left=new TreeNode(11);
		root.left.right=null;
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4);
		root.left.left.right=new TreeNode(2);
		root.left.left.left=new TreeNode(7);
		root.right.right.right=new TreeNode(1);
		root.right.right.left=null;
		System.out.println(hasPathSum3(root, 22));
	}
}
