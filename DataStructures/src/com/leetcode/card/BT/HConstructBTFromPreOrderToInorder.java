package com.leetcode.card.BT;

import java.util.HashMap;
import java.util.Map;

public class HConstructBTFromPreOrderToInorder {
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

	Map<Integer, Integer> hm = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++)
			hm.put(inorder[i], i);
		return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}

	public TreeNode helper(int inorder[], int is, int ie, int preorder[], int ps, int pe) {
		if (is > ie || ps > pe)
			return null;

		TreeNode root = new TreeNode(preorder[ps]);
		int newie = hm.get(preorder[ps]);
		int numleft = newie - is;
		root.left = helper(inorder, is, newie - 1, preorder, ps + 1, ps + numleft);
		root.right = helper(inorder, newie + 1, ie, preorder, ps + numleft + 1, pe);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
