package com.leetcode.problems.easy.strings;

public class LongestNiceSubstring {
	 public static String longestNiceSubstring(String s) {
		 StringBuilder res=new StringBuilder();
	        StringBuilder tmp=new StringBuilder();
	        if(s.length()==1)
	            return "";
	        
	        for(int i=0;i<s.length();i++){
	            if((s.charAt(i)>=65) && (s.charAt(i)<=90) && (s.contains(String.valueOf((char)(s.charAt(i)+32)))))
	                res.append(s.charAt(i));

	            else if(s.charAt(i)>=97 && s.charAt(i)<=122 && (s.contains(String.valueOf((char)(s.charAt(i)-32)))))
	                res.append(s.charAt(i));
	            else
	                break;        
	        }
	        if(res.length()==s.length())
	            return s;
	      for(int i=0;i<s.length();i++){
	              if(res.length()>=2)
	                  tmp=new StringBuilder(res.toString());
		          if(res.length()==0){
		              res.append(s.charAt(i));
		          }else if(res.charAt(res.length()-1)+32==(int)s.charAt(i) || res.charAt(res.length()-1)==(int)s.charAt(i)+32){
		              res.append(s.charAt(i));
		          }else{
	                  if(res.length()>=2){
	                      res.delete(0,res.length());
	                  }else{
		              res.deleteCharAt(res.length()-1);
		             
	                  }
	                   res.append(s.charAt(i));
		          }
		         
		     }
	        if(res.length()<=1 && tmp.length()<=1)
	            return "";
	        if(res.length()> 1 && tmp.length()>1){
	            if(s.indexOf(tmp.charAt(tmp.length()-1))+1==s.indexOf(res.charAt(0)))
	                res=new StringBuilder(tmp.toString()+res.toString());
	        }
	        return (res.length()>tmp.length()) ? new String(res) : new String(tmp);
	    }
	public static void main(String[] args) {
		String s = "BebjJE";
		System.out.println(longestNiceSubstring(s));

	}

}
