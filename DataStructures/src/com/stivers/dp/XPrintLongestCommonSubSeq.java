package com.stivers.dp;

public class XPrintLongestCommonSubSeq {
	 public static String printLongestCommonSubsequence(String text1, String text2) {
	        int arr[][]=new int[text1.length()+1][text2.length()+1];
	        int max=0;
	        for(int i=1;i<arr.length;i++){
	            for(int j=1;j<arr[i].length;j++){
	                if(text1.charAt(i-1)==text2.charAt(j-1)){
	                    arr[i][j]=arr[i-1][j-1]+1;
	                }else {
	                    arr[i][j]=Math.max(arr[i][j-1], arr[i-1][j]);
	                }
	                if(arr[i][j]>max)
	                    max=arr[i][j];
	            }
	        }
	      int i=text1.length();
	      int j=text2.length();
	      String res="";
	      while(i>0 && j>0) {
	    	  if(text1.charAt(i-1)==text2.charAt(j-1)) {
	    		 res=String.valueOf(text1.charAt(i-1))+res;
	    		 i--;
	    		 j--;
	    	  }else if(text1.charAt(i-1)>text2.charAt(j-1)) {
	    		  i--;
	    	  }else {
	    		  j--;
	    	  }
	      }
	      System.out.println(res);
	       return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String s1= "abcde";
		  String s2= "bdgek";
		XPrintLongestCommonSubSeq.printLongestCommonSubsequence(s1, s2);
	}

}
