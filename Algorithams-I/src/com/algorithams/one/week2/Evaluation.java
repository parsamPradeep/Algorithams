package com.algorithams.one.week2;

import java.util.Scanner;

public class Evaluation {

	public static void main(String[] args) {
		GenericLinkedStackOfStrings<String> ops=new GenericLinkedStackOfStrings<String>();
		GenericLinkedStackOfStrings<Double> value=new GenericLinkedStackOfStrings<Double>();
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()) {
			String s = scan.next();
			if(s.equals("("))
				continue;
			else if(s.equals("+"))
				ops.push(s);
			else if(s.equals("*"))
				ops.push("*");
			else if(s.equals(")"))
			{
				String op=ops.pop();
				if(op.equals("+")) value.push(value.pop()+value.pop());
				if(op.equals("*")) value.push(value.pop()*value.pop());
			}
			else {
				
				value.push(Double.valueOf(s));
				
			}
		}
		System.out.println(value.pop());
	}

}
