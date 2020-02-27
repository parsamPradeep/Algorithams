package com.algorithams;

public class JumpSearch {
	public static void jumpSearch(int arr[], int prev, int step, int key) {
		if (step <= arr.length) {
			if (key <= arr[step]) {
				for (int i = prev; i <= step; i++) {
					if (key == arr[i]) {
						System.out.println("element found at :" + i);
					}
				}

			} else {
				prev = step;
				step += step;
				jumpSearch(arr, prev, step, key);
			}

		}else {
			System.out.println("not fount");
		}		
	}

	public static void main(String[] args) {
		// should be sorted array as input array
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int key = -71;
		int step = (int) Math.floor(Math.sqrt(arr.length));
		 jumpSearch(arr, 0, step, key);
		

	}

}
