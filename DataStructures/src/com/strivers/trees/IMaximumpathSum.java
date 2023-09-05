package com.strivers.trees;

public class IMaximumpathSum {
	int max = 0;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		max = root.val;
		int temp = maxPath(root);
		return Math.max(temp, max);
	}

	public int maxPath(TreeNode root) {
		if (root == null)
			return 0;

		int l = maxPath(root.left);
		int r = maxPath(root.right);

		if (l < 0)
			l = 0;
		if (r < 0)
			r = 0;

		int temp = l + r + root.val;

		max = Math.max(max, temp);

		if (l > r)
			return l + root.val;
		else
			return r + root.val;

	}

//Approach - 2
	public int maxPathSum2(TreeNode root) {
		int res[] = new int[1];
		res[0] = -1001;
		maxPath(root, res);
		return res[0];
	}

	public int maxPath(TreeNode root, int res[]) {
		if (root == null)
			return 0;
		int left = Math.max(0, maxPath(root.left, res));
		int right = Math.max(0, maxPath(root.right, res));
		res[0] = Math.max(left + right + root.val, res[0]);
		return root.val + Math.max(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
