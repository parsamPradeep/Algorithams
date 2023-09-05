package com.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class MaxSumPair {
	private TrieNode root;
	Map<String, Integer> map = new HashMap<String, Integer>();

	public class TrieNode {
		private TrieNode[] links;

		private int R = 26;

		private boolean isEnd;
		int val;

		public TrieNode() {
			links = new TrieNode[R];
		}

		public TrieNode(int val) {
			links = new TrieNode[R];
			this.val = val;
		}

		public boolean containsKey(char ch) {
			return links[ch - 'a'] != null;
		}

		public TrieNode get(char ch) {
			return links[ch - 'a'];
		}

		public void put(char ch, TrieNode node) {
			links[ch - 'a'] = node;
		}

		public void setEnd() {
			isEnd = true;
		}

		public boolean isEnd() {
			return isEnd;
		}
	}

	public MaxSumPair() {
		root = new TrieNode();
	}

	public void insert(String key, int val) {
		int delta = val - map.getOrDefault(key, 0);
		map.put(key, val);
		TrieNode node = root;
		node.val += delta;
		for (int i = 0; i < key.length(); i++) {
			char currChar = key.charAt(i);
			if (!node.containsKey(currChar)) {
				node.put(currChar, new TrieNode());
				node = node.get(key.charAt(i));
				node.val += delta;
			} else {
				node = node.get(key.charAt(i));
				node.val = node.val + delta;
			}
		}
	}

	public int sum(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char currChar = prefix.charAt(i);
			node = node.get(currChar);
			if (node == null)
				return 0;
		}
		return node.val;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumPair obj = new MaxSumPair();
		obj.insert("apple", 3);
		int param_2 = obj.sum("ap");
		obj.insert("app", 2);
		obj.insert("apple", 2);
		param_2 = obj.sum("ap");
		System.out.println(param_2);
	}

}
