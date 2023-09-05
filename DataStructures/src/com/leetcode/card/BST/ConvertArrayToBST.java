package com.leetcode.card.BST;

public class ConvertArrayToBST {
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

	public static TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public static TreeNode helper(int nums[], int l, int r) {
		if (l > r)
			return null;
		int m = (l + r) / 2;
		TreeNode root = new TreeNode(nums[m]);
		root.left = helper(nums, l, m - 1);
		root.right = helper(nums, m + 1, r);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6};
		sortedArrayToBST( arr);
	}

}
