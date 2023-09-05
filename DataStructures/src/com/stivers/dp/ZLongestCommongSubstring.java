package com.stivers.dp;

public class ZLongestCommongSubstring {
	public int longestCommonSubString(String text1, String text2) {
		int arr[][] = new int[text1.length() + 1][text2.length() + 1];
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					int val = arr[i - 1][j - 1] + 1;
					arr[i][j] = val;
					max = Math.max(max, val);
				} else {
					arr[i][j] = 0;
				}
			}
		}
		return max;

	}

//Space optimization
	public int longestCommonSubString2(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int prev[] = new int[m + 1];
		int cur[] = new int[m + 1];

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					int val = 1 + prev[j - 1];
					cur[j] = val;
					ans = Math.max(ans, val);
				} else
					cur[j] = 0;
			}
			prev = cur;
		}

		return ans;

	}

}
