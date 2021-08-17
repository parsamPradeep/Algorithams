package com.leetcode.card.BST;

import com.leetcode.card.BST.SearchInBST.TreeNode;

public class InsertInBST {
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
	public static TreeNode inserInToBST(TreeNode root,int val) {
		if(root==null)
			root=new TreeNode(val);
		else if(val<=root.val)
			root.left=inserInToBST(root.left,val);
		else if(val>=root.val)
			root.right=inserInToBST(root.right, val);
		else if(val==root.val)
			root.val=val;
		return root;
	}
	public static void main(String[] args) {
		int arr[]= {4,2,7,1,3};
		TreeNode root=new TreeNode();
		for(int i=0;i<arr.length;i++) {
			inserInToBST(root, arr[i]);
		}

	}

}
