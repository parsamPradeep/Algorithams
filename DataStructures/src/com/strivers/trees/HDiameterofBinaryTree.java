package com.strivers.trees;

public class HDiameterofBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		int res[] = new int[1];
		findHight(root, res);
		return res[0];
	}

	public int findHight(TreeNode root, int maxi[]) {
		if (root == null)
			return 0;
		int left = findHight(root.left, maxi);
		int right = findHight(root.right, maxi);
		maxi[0] = Math.max(maxi[0], left + right);
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
