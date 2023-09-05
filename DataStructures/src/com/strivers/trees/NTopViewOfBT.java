package com.strivers.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class NTopViewOfBT {
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

	public static class Pair {
		Node node;
		int ver;

		Pair(Node node, int ver) {
			this.node = node;
			this.ver = ver;
		}
	}

	// Function to return a list of nodes visible from the top view
	// from left to right in Binary Tree.
	static ArrayList<Integer> topView(Node root) {
		// add your code
		ArrayList<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair pair = q.remove();
			Node node = pair.node;
			int ver = pair.ver;
			if (!map.containsKey(ver)) {
				map.put(ver, node.data);
			}
			if (node.left != null) {
				q.offer(new Pair(node.left, ver - 1));
			}
			if (node.right != null) {
				q.offer(new Pair(node.right, ver + 1));
			}
		}
		for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
			res.add(ent.getValue());
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
