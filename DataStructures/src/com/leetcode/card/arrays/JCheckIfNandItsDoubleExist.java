package com.leetcode.card.arrays;
/*
Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
Example 2:

Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
Example 3:

Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.
 */
import java.util.HashSet;
import java.util.Set;

public class JCheckIfNandItsDoubleExist {
	public static boolean checkIfExist(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
			if (arr[i] != 0) {
				if (set.contains(arr[i] * 2))
					return true;
				if (arr[i] % 2 == 0 && set.contains(arr[i] / 2)) {
					return true;
				}
			} else if (set.size() - 1 != i) {
				return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 909, 121, -296, 872, 807, 715, 407, 94, -8, 572, 90, -520, -867, 485, -918, -827, -728, -653,
				-659, 865, 102, -564, -452, 554, -320, 229, 36, 722, -478, -247, -307, -304, -767, -404, -519, 776, 933,
				236, 596, 954, 464, 817, 1, -723, 187, 128, 577, -787, -344, -920, -168, -851, -222, 773, 614, -699,
				696, -744 };
		boolean res = checkIfExist(arr);
		System.out.println(res);

	}

}
