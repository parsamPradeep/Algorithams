package com.strivers.trees;

public class ULCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
			return null;
		if(root.val==p.val || root.val==q.val)
			return root;
		TreeNode leftLCA=lowestCommonAncestor(root.left, p, q);
		TreeNode rightLCA=lowestCommonAncestor(root.right, p, q);
		
		if(leftLCA!=null && rightLCA!=null) 
			return root;
		return leftLCA!=null?leftLCA:rightLCA;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
