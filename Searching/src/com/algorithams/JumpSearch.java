package com.algorithams;

public class JumpSearch {
	public static void jumpSearch(int arr[], int str, int end, int key) {
		if (end <= arr.length) {
			if (key <= arr[end]) {
				for (int i = str; i <= end; i++) {
					if (key == arr[i]) {
						System.out.println("element found at :" + i);
					}
				}

			} else {
				str = end;
				end += end;
				jumpSearch(arr, str, end, key);
			}

		}else {
			System.out.println("not fount");
		}		
	}

	public static void main(String[] args) {
		// should be sorted array as input array
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int key = -71;
		int end = (int) Math.floor(Math.sqrt(arr.length));
		 jumpSearch(arr, 0, end, key);
		

	}

}
