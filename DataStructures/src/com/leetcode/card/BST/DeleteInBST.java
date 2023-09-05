package com.leetcode.card.BST;
//https://www.youtube.com/watch?v=kouxiP_H5WE
public class DeleteInBST {
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
	public static TreeNode delete(TreeNode root, int key) {
		if (root == null)
			return null;
		if (root.val == key)
			return helper(root);
		TreeNode dummy = root;
		while (root != null) {
			if (key < root.val) {
				if (root.left != null && root.left.val == key) {
					root.left = helper(root.left);
					break;
				} else {
					root = root.left;
				}
			} else {
				if (root.right != null && root.right.val == key) {
					root.right = helper(root.right);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return dummy;
	}

	public static TreeNode helper(TreeNode root) {
		if (root.right == null) {
			return root.left;
		} else if (root.left == null) {
			return root.right;
		} else {
			TreeNode rightChild = root.right;
			TreeNode lastRight = findLastRight(root.left);
			lastRight.right = rightChild;
			return root.left;
		}
	}

	public static TreeNode findLastRight(TreeNode root) {
		if (root.right == null)
			return root;
		return findLastRight(root.right);
	}

// Approach - 2 Modified version of Approach -1
	public static TreeNode deleteNode2(TreeNode root, int key) {
		if (root == null)
			return null;

		if (root.val > key) {
			root.left = deleteNode2(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode2(root.right, key);
		} else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			TreeNode rightChild = root.right;
			TreeNode lastRight = root.left;
			while (lastRight.right != null)
				lastRight = lastRight.right;
			lastRight.right = rightChild;
			return root.left;
		}
		return root;
	}

// Approach - 3
	public TreeNode deleteNode3(TreeNode root, int key) {
		if (root == null)
			return null;

		if (root.val > key) {
			root.left = deleteNode3(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode3(root.right, key);
		} else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			TreeNode rightSmallest = root.right;
			while (rightSmallest.left != null)
				rightSmallest = rightSmallest.left;
			rightSmallest.left = root.left;
			return root.right;
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(6);
		root.right.right=new TreeNode(2);
		root.right.left=new TreeNode(4);
		root.left.left=new TreeNode(7);
		delete(root, 3);
	}

}
