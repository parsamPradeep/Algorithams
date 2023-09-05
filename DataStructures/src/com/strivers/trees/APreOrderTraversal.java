package com.strivers.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class APreOrderTraversal {

	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return res;
		if (root != null)
			res.add(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		return res;

	}

	// Approach - 2 Iterative
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> st = new Stack<>();
		st.add(root);
		while (!st.isEmpty()) {
			TreeNode node = st.pop();
			res.add(node.val);
			if (node.right != null)
				st.push(node.right);
			if (node.left != null)
				st.push(node.left);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
