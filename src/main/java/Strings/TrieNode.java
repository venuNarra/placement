package Strings;

public class TrieNode {
	char data;
	boolean isEndOfString;
	TrieNode[] child=new TrieNode[26];
	
	TrieNode() {
		// TODO Auto-generated constructor stub
		isEndOfString=false;
		for(int i=0;i<26;i++)
			child[i]=null;
	}
	TrieNode(char c) {
		this();
		data=c;	
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public boolean isEndOfString() {
		return isEndOfString;
	}

	public void setEndOfString(boolean isEndOfString) {
		this.isEndOfString = isEndOfString;
	}

	public TrieNode[] getChild() {
		return child;
	}

	public void setChild(TrieNode[] child) {
		this.child = child;
	}
	
}
