package com.leetcode.card.BT;

import java.util.ArrayList;
import java.util.List;

public class DLevelOrderTraversal {
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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<>();
		levelOrderHelper(output, root, 0);
		return output;
	}

	public void levelOrderHelper(List<List<Integer>> output, TreeNode root, int level) {
		if (root == null) {
			return;
		} else {
			if (level >= output.size()) {
				output.add(new ArrayList<>());
			}
			output.get(level).add(root.val);
			levelOrderHelper(output, root.left, level + 1);
			levelOrderHelper(output, root.right, level + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
