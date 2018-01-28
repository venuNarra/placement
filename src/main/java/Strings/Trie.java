package Strings;

public class Trie {
	public static void  insert(TrieNode root,String key) {
		TrieNode temp=root;
		for(int i=0;i<key.length();i++) {
			TrieNode node=new TrieNode(key.charAt(i));
			int index=key.charAt(i)-'a';
			if(temp.child[index]==null)
				temp.child[index]=node;
			temp=temp.child[index];		
		}
		
		temp.isEndOfString=true;
	}
	public static boolean search(TrieNode root,String key) {
		TrieNode temp=root;
		for(int i=0;i<key.length();i++) {
			int index=key.charAt(i)-'a';
			if(temp.child[index]==null)
				return false;
			temp=temp.child[index];	
		}
		return temp!=null && temp.isEndOfString();
		
	}
public static void main(String[] args)
{
	String keys[] = {"the", "a", "there", "answer", "any",
            "by", "bye", "their"};
	TrieNode root = new TrieNode();
	for(int i=0;i<keys.length;i++)
		insert(root,keys[i]);
	System.out.println(search(root,"answer"));
	
}
}
