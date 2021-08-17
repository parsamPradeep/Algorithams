package com.leetcode.problems.easy.strings;

public class IntegerToRoman {
	
	public static String integerToRoman(int num) {
		String unit[]= {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
		String ten[]= {"","X","XX","XXX","XL","L","LX","LXX","LXXX","CX"};
		String hunderd[]= {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String thousand[]= {"","M","MM","MMM"};
		
		return thousand[num/1000]+
				hunderd[(num%1000)/100]+
				ten[(num%100)/10]+
				unit[num%10];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
