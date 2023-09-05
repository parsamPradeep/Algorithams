package com.stivers.dp;

public class FHourseRobber {
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);

		int p1wofirst = 0;
		int p2wofirst = nums[1];
		int p1wolast = nums[0];
		int p2wolast = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int temp1 = p2wofirst;
			p2wofirst = Math.max(nums[i] + p1wofirst, p2wofirst);
			p1wofirst = temp1;
			if (i != nums.length - 1) {
				int temp2 = p2wolast;
				p2wolast = Math.max(nums[i] + p1wolast, p2wolast);
				p1wolast = temp2;
			}
		}
		return Math.max(p2wofirst, p2wolast);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 5, 1, 2, 6 };
		System.out.println(rob(arr));

	}

}
