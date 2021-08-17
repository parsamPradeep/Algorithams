package com.gkg.arrays.rotation;
/*
Input: N = 657
Output: 765
Explanation: All rotations of 657 are {657, 576, 765}. 
The maximum value among all these rotations is 765.

Input: N = 7092
Output: 9270
Explanation:
All rotations of 7092 are {7092, 2709, 9270, 0927}. 
The maximum value among all these rotations is 9270.
 */
public class MaxValueByRotatingDigitsOfGivenNumber {

	
	public static int maxValue(int num) {
		int ans=num;
		int len=String.valueOf(num).length();
		int x=(int)Math.pow(10, len-1);
		for(int i=1;i<len;i++) {
			int lastDigit=num%10;
			num=num/10;
			
			num=num+(lastDigit*x);
			if(num>ans) {
				ans=num;
			}
			
		}
		return ans;
	}
	public static void main(String[] args) {
		int res=maxValue(567);
		System.out.println(res);

	}

}
