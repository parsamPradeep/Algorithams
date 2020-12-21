package com.algorithams.one.week4;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private class Node{
		private Key key;
		private Value value;
		private Node left, right;
		public Node(Key key, Value value){
			this.key=key;
			this.value=value;
		}
	}
	private Node root;
	private void put(Key key, Value value) {
		root=put(root, key, value);
	}
	private Node put(Node x, Key key, Value value) {
		if(x==null)
			return new Node(key, value);
		int cmp=key.compareTo(x.key);
		if(cmp<0)
			x.left=put(x.left,key,value);
		if(cmp>0)
			x.right=put(x.right, key, value);
		if(cmp==0)
			x.value=value;
		return x;
	}
	private Value get(Key key) {
		Node x=root;
		while(x!=null) {
			int cmp=key.compareTo(x.key);
			if(cmp<0)
				x=x.left;
			if(cmp>0)
				x=x.right;
			if(cmp==0)
				return x.value;
		}
		return null;
	}

}
