package com.strivers.trees;

public class WChildrenSum {
	public static void changeTree(TreeNode  root) {
        helper(root);
    }
    public static void helper(TreeNode  root){
        if(root==null) return;
        int child=0;
        if(root.left!=null) child+=root.left.val;
        if(root.right!=null) child+=root.right.val;
        if(child>=root.val) root.val=child;
        else{
            if(root.left!=null) root.left.val=root.val;
             if(root.right!=null) root.right.val=root.val;
        }
        helper(root.left);
        helper(root.right);
        int tot=0;

        if(root.left!=null) tot+=root.left.val;
        if(root.right!=null) tot+=root.right.val;
        if(root.right!=null || root.left!=null) root.val=tot;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
