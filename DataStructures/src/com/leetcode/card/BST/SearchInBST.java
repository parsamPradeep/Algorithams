package com.leetcode.card.BST;

import com.leetcode.card.BST.ValidBinarySearchTree.TreeNode;

public class SearchInBST {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
}
	public static TreeNode searchBST(TreeNode root, int val) {
		while(root!=null) {
			if(val==root.val)
				return root;
			else if(val<root.val)
				root=root.left;
			else
				root=root.right;
		}
		return null;
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode();
		root.val=4;
		root.left=new TreeNode(2);
		root.left=new TreeNode(7);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		

	}

}
