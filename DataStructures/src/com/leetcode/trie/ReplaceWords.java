package com.leetcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
	private TrieNode root = new TrieNode();
	
	public String replaceWords(List<String> dictionary, String sentence) {
		TrieNode node = root;
		for (int i = 0; i < dictionary.size(); i++) {
			String s = dictionary.get(i);
			node=root;
			for (int j = 0; j < s.length(); j++) {
				char currChar = s.charAt(j);
				if (!node.children.containsKey(currChar)) {
					node.children.put(currChar, new TrieNode());
					node = node.children.get(s.charAt(j));
				} else {
					node = node.children.get(s.charAt(j));
				}
			}
			node.isEnd=true;
		}

		node = root;
		String res = "";
		String temp="";
		for (int i = 0; i < sentence.length(); i++) {
			char currChar = sentence.charAt(i);
			if (currChar != ' ' && node.children.containsKey(currChar)) {
				node = node.children.get(currChar);
				temp+=String.valueOf(currChar);
			} else {
				res = node.isEnd ? res+temp+" " : res+temp+String.valueOf(currChar);
				while(node.isEnd && i<sentence.length()) {
					currChar = sentence.charAt(i);
					if(currChar != ' ') 
						i++;
					else
						break;
				}
				temp="";
				node=root;
			}
			
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceWords rw = new ReplaceWords();
		List<String> dic=new ArrayList<String>();
		dic.add("a");
		dic.add("b");
		dic.add("c");
		
		String sentence = "aadsfasf absbs bbab cadsfafs";
		rw.replaceWords(dic, sentence);

	}

}
class TrieNode {
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isEnd;
}

