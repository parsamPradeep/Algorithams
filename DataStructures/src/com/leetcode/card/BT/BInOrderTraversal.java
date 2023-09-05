package com.leetcode.card.BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BInOrderTraversal {
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

	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return res;
		inorderTraversal(root.left);
		res.add(root.val);
		inorderTraversal(root.right);
		return res;
	}

	// Approch - 2 Itterative
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		while (true) {
			while (root != null) {
				st.push(root);
				root = root.left;
			}
			if (st.isEmpty())
				break;
			TreeNode node = st.pop();
			res.add(node.val);
			root = node.right;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
