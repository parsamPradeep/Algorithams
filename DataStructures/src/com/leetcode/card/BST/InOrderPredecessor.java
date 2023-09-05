package com.leetcode.card.BST;

public class InOrderPredecessor {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public static TreeNode predecessor(TreeNode root, TreeNode p) {
		TreeNode successor=null;
		while(root!=null) {
			if(p.val<root.val) {
				root=root.left;
			}else {
				successor=root;
				root=root.right;
			}
		}
		return successor;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left=new TreeNode(3);
		root.right=new TreeNode(6);
		root.right.right=new TreeNode(8);
		root.right.left=new TreeNode(5);
		root.left.right=new TreeNode(2);
		TreeNode result=predecessor(root, new TreeNode(3));
		System.out.println(result.val);

	}

}
