package com.strivers.trees;

import java.util.ArrayList;
import java.util.List;

public class LBoundaryTraversalofBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		// write your code here
		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		if (!isLeaf(root))
			ans.add(root.val);
		leftBoundary(root, ans);
		leafnode(root, ans);
		rightBoundary(root, ans);
		return ans;
	}

	private void leftBoundary(TreeNode root, List<Integer> res) {
		TreeNode curr = root.left;
		while (curr != null) {
			if (!isLeaf(curr))
				res.add(curr.val);
			if (curr.left != null)
				curr = curr.left;
			else
				curr = curr.right;
		}
	}

	private void rightBoundary(TreeNode root, List<Integer> res) {
		TreeNode curr = root.right;
		List<Integer> temp = new ArrayList<>();
		while (curr != null) {
			if (!isLeaf(curr))
				temp.add(curr.val);
			if (curr.right != null)
				curr = curr.right;
			else
				curr = curr.left;
		}
		for (int i = temp.size() - 1; i >= 0; i--) {
			res.add(temp.get(i));
		}
	}

	private void leafnode(TreeNode root, List<Integer> res) {
		if (isLeaf(root))
			res.add(root.val);
		if (root.left != null)
			leafnode(root.left, res);
		if (root.right != null)
			leafnode(root.right, res);
	}

	private boolean isLeaf(TreeNode root) {
		if (root.left == null && root.right == null)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
