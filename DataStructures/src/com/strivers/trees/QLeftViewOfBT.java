package com.strivers.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class QLeftViewOfBT {
	
	public static List<Integer> leftSideView(TreeNode root) {
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
//Approach - 2
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	class Pair {
		Node node;
		int lel;

		Pair(Node node, int lel) {
			this.node = node;
			this.lel = lel;
		}
	}

	// Function to return list containing elements of left view of binary tree.
	ArrayList<Integer> leftView(Node root) {
		// Your code here
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair p = q.remove();
			Node node = p.node;
			int lel = p.lel;
			if (map.get(lel) == null)
				map.put(lel, node.data);
			if (node.left != null)
				q.offer(new Pair(node.left, lel + 1));
			if (node.right != null)
				q.offer(new Pair(node.right, lel + 1));
		}
		for (Integer key : map.keySet()) {
			res.add(map.get(key));
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
