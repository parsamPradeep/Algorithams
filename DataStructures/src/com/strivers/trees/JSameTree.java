package com.strivers.trees;

import java.util.Stack;

public class JSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
		Stack<TreeNode> node1 = new Stack<>();
		Stack<TreeNode> node2 = new Stack<>();
		node1.push(p);
		node2.push(q);
		while (!node1.isEmpty() && !node2.isEmpty()) {
			TreeNode i = node1.pop();
			TreeNode j = node2.pop();
			if (i == null || j == null)
				return false;
			if (i.val != j.val)
				return false;
			if (i.left != null && j.left == null)
				return false;
			if (i.left == null && j.left != null)
				return false;
			if (i.left != null) {
				node1.push(i.left);
				node2.push(j.left);
			}
			if (j.right != null) {
				node1.push(i.right);
				node2.push(j.right);
			}
		}
		return true;
	}

//Approach - 2
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null && q != null || p != null && q == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
