package com.strivers.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KZigZagTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		boolean flag = true;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> temp = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node != null) {
					temp.add(node.val);
					if (node.left != null)
						q.add(node.left);
					if (node.right != null)
						q.add(node.right);
				}
			}
			if (flag) {
				res.add(new ArrayList<>(temp));
			} else {
				Collections.reverse(temp);
				res.add(new ArrayList<>(temp));
			}
			flag = !flag;

		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
