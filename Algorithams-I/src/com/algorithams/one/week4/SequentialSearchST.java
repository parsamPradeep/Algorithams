package com.algorithams.one.week4;

// sequential search with linked list implementation
public class SequentialSearchST<Key, Value> {
	public int n;
	public Node first;

	public class Node {
		private Key key;
		private Value values;
		private Node next;

		Node(Key key, Value value, Node node) {
			this.key = key;
			this.values = value;
			this.next = node;
		}
	}

	public SequentialSearchST() {

	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return n;
	}

	public boolean contain(Key key) {
		if (key == null)
			throw new IllegalArgumentException("arguent to get() is null");
		return get(key) != null;
	}

	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		for (Node i = first; i != null; i = i.next) {
			if (key.equals(i.key)) {
				return i.values;
			}
		}
		return null;

	}

	public void put(Key key, Value value) {
		if (key == null)
			throw new IllegalArgumentException("argumet in put() is null");
		if (value == null) {
			delete(key);
			return;
		}
		for (Node i = first; i != null; i = i.next) {
			if (key.equals(i.key)) {
				i.values = value;
				return;
			}
		}
		first = new Node(key, value, first);
		n++;

	}

	public void delete(Key key) {
		if (first == null)
			return;
		if (key == null)
			throw new IllegalArgumentException("argument to delete is null");

		Node temp = first, prev = null;
		if (temp.key.equals(key)) {
			first = temp.next;
			return;
		}
		while (temp != null && temp.key != key) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null)
			return;
		prev.next = temp.next;

	}
	public void print() {
		for (Node node=first;node!=null;node=node.next)
			System.out.print(node.key + " ");
	}
	 public static void main(String[] args) {
	        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
	        String str="PRADEEP";
	        for (int i = 0; i<str.length(); i++) {
	            st.put(String.valueOf(str.charAt(i)), i);
	        }
	        System.out.print("printing before Delete :-");
			st.print();
			st.delete("E");
			System.out.println();
			System.out.print("printing after Delete :-");
			st.print();
	    }
}
