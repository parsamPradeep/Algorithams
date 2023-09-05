package com.leetcode.card.BT;
//https://www.youtube.com/watch?v=LgLRTaEMRVc
import java.util.HashMap;
import java.util.Map;


public class IConstructBTFromInorderToPostOrder {
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
	Map<Integer, Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) { 
        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i], i);
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode helper(int inorder[], int is, int ie, int postorder[], int ps, int pe){
        if(is>ie || ps>pe) return null;
       
        TreeNode root=new TreeNode(postorder[pe]);
        int newie=hm.get(postorder[pe]);
        int numleft=newie-is;
        root.left=helper(inorder, is, newie-1, postorder, ps, ps+numleft-1);
        root.right=helper(inorder, newie+1, ie, postorder, ps+numleft, pe-1);
        return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
