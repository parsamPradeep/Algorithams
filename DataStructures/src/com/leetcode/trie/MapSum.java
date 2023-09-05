package com.leetcode.trie;

import java.util.HashMap;

public class MapSum {
	HashMap<String, Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }
    public void insert(String key, int val) {
        map.put(key, val);
    }
    public int sum(String prefix) {
        int ans = 0;
        for (String key: map.keySet()) {
            if (key.startsWith(prefix)) {
                ans += map.get(key);
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapSum obj = new MapSum();
		obj.insert("apple", 3);
		int param_2 = obj.sum("ap");
		obj.insert("app", 2);
		obj.insert("apple", 2);
		param_2 = obj.sum("ap");
		System.out.println(param_2);

	}

}
