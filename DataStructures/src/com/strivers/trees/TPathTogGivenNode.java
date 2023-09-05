package com.strivers.trees;

import java.util.List;

public class TPathTogGivenNode {
	 
	public static boolean helper(TreeNode node, List<Integer> ds) {
		if(node==null) return false;
		ds.add(node.val);
		if(helper(node.left, ds) || helper(node.right, ds))
			return true;
		ds.remove(ds.size()-1);
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
