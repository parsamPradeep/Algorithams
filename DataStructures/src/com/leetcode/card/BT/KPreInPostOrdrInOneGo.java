package com.leetcode.card.BT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KPreInPostOrdrInOneGo {
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
	public static class Pair{
		TreeNode node;
		int num;
		Pair(TreeNode node, int num){
			this.node=node;
			this.num=num;
		}
	}
	public static void preInPost(TreeNode root) {
		List<Integer> pre=new ArrayList<>();
		List<Integer> in=new ArrayList<>();
		List<Integer> post=new ArrayList<>();
		Stack<Pair> st=new Stack<>();
		st.push(new Pair(root, 1));
		while(!st.isEmpty()) {
			Pair node=st.pop();
			if(node.num==1) {
				pre.add(node.node.val);
				node.num++;
				st.push(node);
				if(node.node.left!=null) st.push(new Pair(node.node.left,1));
				
			}else if(node.num==2) {
				in.add(node.node.val);
				node.num++;
				st.push(node);
				if(node.node.right!=null) st.push(new Pair(node.node.right, 1));
			}else {
				post.add(node.node.val);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
