package com.leetcode.card.BST;

import java.util.PriorityQueue;

public class KthLargest {
		public static PriorityQueue<Integer> kthLargest(int nums[]) {
			 PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			 for(int i:nums)
				 queue.add(i);
			 return  queue; 
		}
	public static void main(String[] args) {
		int nums[]= {4,5,8,2};
		PriorityQueue<Integer> queue =kthLargest(nums);
		System.out.println(queue.poll());
		queue.add(3);   // return 4
		System.out.println(queue.poll());
		queue.add(5);   // return 5
		System.out.println(queue.poll());
		queue.add(10);  // return 5
		System.out.println(queue.poll());
		queue.add(9);   // return 8
		System.out.println(queue.poll());
		queue.add(4);   // return 8
	}

}
