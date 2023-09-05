package com.strivers.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CPostOrderTraversal {
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return res;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		res.add(root.val);
		return res;
	}

// Approach - 2 Iterative
	public static List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		st1.push(root);
		while (!st1.isEmpty()) {
			TreeNode node = st1.pop();
			st2.push(node);
			if (node.left != null)
				st1.push(node.left);
			if (node.right != null)
				st1.push(node.right);
		}
		while (!st2.isEmpty()) {
			TreeNode node = st2.pop();
			res.add(node.val);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
