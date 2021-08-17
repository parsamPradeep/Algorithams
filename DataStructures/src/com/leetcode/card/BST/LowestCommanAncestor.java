package com.leetcode.card.BST;
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that h
as both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of
 itself according to the LCA definition.
 */
public class LowestCommanAncestor {
	static Node root;
	public static class Node {
		Node left;
		Node right;
		int val;
		Node(int val){
			this.val=val;
		}
	}
	public static Node lowestCommanAncestor(Node root, int p,int q) {
		if(root==null)
			return null;
		if(root.val==p || root.val==q)
			return root;
		Node leftLCA=lowestCommanAncestor(root.left, p, q);
		Node rightLCA=lowestCommanAncestor(root.right, p, q);
		
		if(leftLCA!=null && rightLCA!=null) 
			return root;
		return leftLCA!=null?leftLCA:rightLCA;
	}
	public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        root=tree;
       System.out.println(lowestCommanAncestor(root, 5, 6).val);
	}

}
