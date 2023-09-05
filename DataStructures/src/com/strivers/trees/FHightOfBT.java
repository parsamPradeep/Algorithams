package com.strivers.trees;

public class FHightOfBT {
	int total=0;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right );
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
