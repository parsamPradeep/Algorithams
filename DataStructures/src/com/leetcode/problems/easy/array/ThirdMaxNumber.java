package com.leetcode.problems.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaxNumber {
	// Approach - 1
	public static int thirdMax1(int[] nums) {
		Integer max1, max2, max3;
		max1 = max2 = max3 = null;
		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3))
				continue;
			if (max1==null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2==null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3==null || n > max3) {
				max3 = n;
			}

		}
		return max3 == null ? max1 : max3;
	}

	// Approach - 2
	public static int thirdMax2(int[] nums) {
		int p1, p2, p3;
		p1 = p2 = p3 = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= p1 && !set.contains(nums[i])) {
				p3 = p2;
				p2 = p1;
				p1 = nums[i];
				set.add(nums[i]);

			} else if (nums[i] >= p2 && !set.contains(nums[i])) {
				p3 = p2;
				p2 = nums[i];
				set.add(nums[i]);

			} else if (nums[i] >= p3 && !set.contains(nums[i])) {
				p3 = nums[i];
				set.add(nums[i]);
			}
		}

		return set.size() <= 2 ? p1 : p3;
	}

	public static void main(String[] args) {
		int nums[] = { 3, 2, 1 };
		System.out.println(thirdMax1(nums));

	}

}
