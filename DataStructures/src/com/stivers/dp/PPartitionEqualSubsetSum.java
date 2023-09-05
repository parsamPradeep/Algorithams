package com.stivers.dp;

import java.util.Arrays;

public class PPartitionEqualSubsetSum {

//Recursion
	public boolean canPartitionRecur(int[] nums) {
		int totalSum = 0;
		for (int i : nums)
			totalSum += i;
		if (totalSum % 2 != 0)
			return false;
		return helper(0, totalSum / 2, 0, nums);
	}

	public boolean helper(int inx, int target, int tempTarg, int nums[]) {
		if (target == tempTarg)
			return true;
		if (inx == nums.length - 1)
			return nums[inx] + tempTarg == target;

		boolean notTaken = helper(inx + 1, target, tempTarg, nums);
		boolean taken = false;
		if (nums[inx] + tempTarg <= target)
			taken = helper(inx + 1, target, tempTarg + nums[inx], nums);
		return notTaken || taken;
	}

//Memoization
	public boolean canPartitionMemo(int[] nums) {
		int totalSum = 0;
		for (int i : nums)
			totalSum += i;
		if (totalSum % 2 != 0)
			return false;
		int dp[][] = new int[nums.length][totalSum / 2];
		for (int arr[] : dp)
			Arrays.fill(arr, -1);

		return helper(0, totalSum / 2, 0, nums, dp);
	}

	public boolean helper(int inx, int target, int tempTarg, int nums[], int dp[][]) {
		if (target == tempTarg)
			return true;
		if (inx == nums.length - 1)
			return nums[inx] + tempTarg == target;

		if (dp[inx][tempTarg] != -1)
			return dp[inx][tempTarg] == 1 ? true : false;
		boolean notTaken = helper(inx + 1, target, tempTarg, nums, dp);
		boolean taken = false;
		if (nums[inx] + tempTarg <= target)
			taken = helper(inx + 1, target, tempTarg + nums[inx], nums, dp);
		dp[inx][tempTarg] = (taken || notTaken) ? 1 : 0;
		return notTaken || taken;
	}

//Tabulation
	public boolean canPartitiontab(int[] nums) {
		int totalSum = 0;
		for (int i : nums)
			totalSum += i;
		if (totalSum % 2 != 0)
			return false;
		int target = totalSum / 2;
		boolean dp[][] = new boolean[nums.length][target + 1];
		for (int i = 0; i < nums.length; i++)
			dp[i][0] = true;
		if (nums[0] < target)
			dp[0][nums[0]] = true;
		for (int inx = 1; inx < nums.length; inx++) {
			for (int k = 1; k <= target; k++) {
				boolean notTaken = dp[inx - 1][k];
				boolean taken = false;
				if (nums[inx] <= k)
					taken = dp[inx - 1][k - nums[inx]];
				dp[inx][k] = notTaken || taken;
			}
		}
		return dp[nums.length - 1][target];

	}

//Space Optimization
	public boolean canPartitionSpace(int[] nums) {
		int totalSum = 0;
		for (int i : nums)
			totalSum += i;
		if (totalSum % 2 != 0)
			return false;
		int target = totalSum / 2;
		boolean temp[] = new boolean[target + 1];
		temp[0] = true;
		if (nums[0] < target)
			temp[nums[0]] = true;
		for (int inx = 1; inx < nums.length; inx++) {
			boolean curr[] = new boolean[target + 1];
			for (int k = 1; k <= target; k++) {
				boolean notTaken = temp[k];
				boolean taken = false;
				if (nums[inx] <= k)
					taken = temp[k - nums[inx]];
				curr[k] = notTaken || taken;
			}
			temp = curr;
		}
		return temp[target];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
