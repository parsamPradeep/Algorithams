package com.algorithams.one.week4;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int n = 0;
	private static int INTITUAL_CAPACITY = 2;

	public BinarySearchST() {
		this(INTITUAL_CAPACITY);
	}

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Comparable[capacity];
	}
	
    // resize the underlying arrays
	private void resize(int capacity) {
		Key[] tempKeys = (Key[]) new Comparable[capacity];
		Value[] tempValues = (Value[]) new Comparable[capacity];
		for (int i = 0; i < n; i++) {
			tempKeys[i] = keys[i];
			tempValues[i] = values[i];
		}
		keys = tempKeys;
		values = tempValues;
	}

	//Returns the number of key-value pairs in this symbol table.
	public int size() {
		return n;
	}

	//Returns true if this symbol table is empty.
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//  Does this symbol table contain the given key?
	public boolean contain(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument contain null value");
		return get(key) != null;
	}

	//Returns the value associated with the given key in this symbol table.
	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument contain null value");
		if (isEmpty())
			return null;
		int i = rank(key);
		if (keys[i].compareTo(key) == 0)
			return values[i];
		return null;
	}

	//Returns the number of keys in this symbol table strictly less than key
	public int rank(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument contain null value");
		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	/* 1. Inserts the specified key-value pair into the symbol table, overwriting the old 
    value with the new value if the symbol table already contains the specified key.
       2. Deletes the specified key (and its associated value) from this symbol table
    if the specified value is null. */
	public void put(Key key, Value value) {
		if (key == null)
			throw new IllegalArgumentException("argument contain null value");
		if (value == null) {
			delete(key);
			return;
		}
		int i = rank(key);

		if (i < n && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}

		if (n == keys.length)
			resize(2 * keys.length);
		for (int j = n; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		n++;
	}

	// Removes the specified key and associated value from this symbol table
	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("Symbol table underflow error");
		if (isEmpty())
			return;

		int i = rank(key);
		if (keys[i].compareTo(key) != 0) {
			return;
		}
		for (int j = i; j < n - 1; j++) {
			keys[j] = keys[j + 1];
			values[j] = values[j + 1];
		}

		n--;
		keys[n] = null;
		values[n] = null;
		if (n > 0 && n == keys.length / 4)
			resize(keys.length / 2);
	}

	public void print() {
		for (int i = 0; i < keys.length; i++)
			System.out.print(keys[i] + " ");
	}

	public static void main(String[] args) {

		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
		String str = "PRADEEP";
		for (int i = 0; i < str.length(); i++) {
			st.put(String.valueOf(str.charAt(i)), i);
		}
		System.out.print("printing before Delete :-");
		st.print();
		st.delete("D");
		System.out.println();
		System.out.print("printing after Delete :-");
		st.print();
	}

}
