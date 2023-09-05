package com.strivers.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PRightViewOfBT {
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res, 0);
		return res;
	}

	public static void helper(TreeNode root, List<Integer> res, int lel) {
		if (root == null)
			return;
		if (lel == res.size()) {
			res.add(root.val);
		}
		helper(root.right, res, lel + 1);
		helper(root.left, res, lel + 1);
	}

	// Approach -2
	public class Pair {
		TreeNode node;
		int lel;

		Pair(TreeNode node, int lel) {
			this.node = node;
			this.lel = lel;
		}
	}

	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<Pair> q = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair p = q.poll();

			TreeNode node = p.node;
			int lel = p.lel;

			if (!map.containsKey(lel))
				map.put(lel, node.val);
			if (node.right != null)
				q.offer(new Pair(node.right, lel + 1));
			if (node.left != null)
				q.offer(new Pair(node.left, lel + 1));
		}
		for (Integer k : map.keySet()) {
			res.add(map.get(k));
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
