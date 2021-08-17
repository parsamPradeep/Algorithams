package com.leetcode.problems.easy.array;

import java.util.ArrayList;
import java.util.List;

public class CountItemsMatchingARule {
	 public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
	        int ruleIndex=ruleKey.equals("type")?0:ruleKey.contentEquals("color")?1:2;
	        int res=0;
	        for(int i=0;i<items.size();i++){
	    
	                if(ruleValue.equals(items.get(i).get(ruleIndex)))
	                    res++;
	            
	        }
	        return res;
	    }
	public static void main(String[] args) {
		List<List<String>>items=new ArrayList<List<String>>();
		List i1=new ArrayList();
		i1.add("phone");
		i1.add("blue");
		i1.add("pixel");
		List i2=new ArrayList();
		i2.add("computer");
		i2.add("silver");
		i2.add("lenovo");
		List i3=new ArrayList();
		i3.add("phone");
		i3.add("gold");
		i3.add("iphone");
		items.add(i1);
		items.add(i2);
		items.add(i3);
		
		String ruleKey="color";
		String ruleValue="silver";
		int res=countMatches(items, ruleKey, ruleValue);
		System.out.println(res);

	}

}
