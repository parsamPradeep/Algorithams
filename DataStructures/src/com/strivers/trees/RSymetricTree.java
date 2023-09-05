package com.strivers.trees;

import java.util.LinkedList;
import java.util.Queue;

public class RSymetricTree {
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(root.left);
		q2.offer(root.right);

		while (q1.size() > 0 && q2.size() > 0) {
			TreeNode n1 = q1.poll();
			TreeNode n2 = q2.poll();

			if (n1 == null && n2 != null || n1 != null && n2 == null)
				return false;

			if (n1 != null && n2 != null && n1.val != n2.val)
				return false;

			if (n1 != null) {
				q1.offer(n1.right);
				q1.offer(n1.left);
			}
			if (n2 != null) {
				q2.offer(n2.left);
				q2.offer(n2.right);
			}

		}

		return q1.isEmpty() && q2.isEmpty() ? true : false;
	}
	
//Approach - 2
	 public boolean isSymmetric2(TreeNode root) {
		    return root==null || isSymmetricHelp(root.left, root.right);
		}

		private boolean isSymmetricHelp(TreeNode left, TreeNode right){
		    if(left==null || right==null)
		        return left==right;
		    if(left.val!=right.val)
		        return false;
		    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
