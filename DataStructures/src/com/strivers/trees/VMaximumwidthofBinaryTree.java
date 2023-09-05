package com.strivers.trees;

import java.util.LinkedList;
import java.util.Queue;

public class VMaximumwidthofBinaryTree {
	class Pair{
        TreeNode node;
        int inx;
        Pair(TreeNode node, int inx){
            this.node=node;
            this.inx=inx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        if(root==null) return 0;
        int res=0;
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            
            int size=q.size();
            int min=q.peek().inx;
            int max=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode node=p.node;
                int inx=p.inx;
                int newInx=inx-min;
                if(node.left!=null) q.offer(new Pair(node.left, (2*newInx)+1));
                if(node.right!=null) q.offer(new Pair(node.right, (2*newInx)+2));
                max=Math.max(max, inx);
            }
            res=Math.max(res, max-min+1);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
