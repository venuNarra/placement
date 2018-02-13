package cache;
import java.util.HashMap;

public class LRUCache {
	int capacity;
	HashMap<Integer,DLLNode> map=new HashMap<Integer, DLLNode>();
	DLLNode head;
	DLLNode tail;
	
	LRUCache(int capacity){
		this.capacity=capacity;
	}
	
	public void put(int key,int value){
		if(map.containsKey(key)) {
			DLLNode oldNode=map.get(key);
			oldNode.value=value;
			remove(oldNode);
			setHead(oldNode);
			}else {
				DLLNode newNode=new DLLNode(key, value);
				if(map.size()>=capacity) {
					map.remove(tail.key);
					remove(tail);
				}
				setHead(newNode);
				map.put(key, newNode);
			}
	}
	public void remove(DLLNode node){
		if(node.prev!=null) {
			node.prev.next=node.next;
		}else {
			head=node.next;
		}
		if(node.next!=null) {
			node.next.prev=node.prev;
		}else {
			tail=node.prev;
		}
	}
	public void setHead(DLLNode node) {
		node.next=head;
		node.prev=null;
		if(head!=null) {
			head.prev=node;
		}
		head=node;
		if(tail==null)
			tail=head;
	}
	public int get(int key) {
		if(map.containsKey(key)) {
			DLLNode node=map.get(key);
			remove(node);
			setHead(node);
			return node.getValue();
		}
		return -1;
	}
	public void print() {
		DLLNode temp=head;
		while(temp!=null) {
			System.out.println(temp.getKey() +" "+ temp.getValue());
			temp=temp.getNext();
			
		}
	}
	public static void main(String[] args) {
		LRUCache lruCache=new LRUCache(3);
		lruCache.put(1, 100);
		lruCache.put(2, 200);
	lruCache.put(3, 300);
	lruCache.put(4, 400);
	lruCache.put(5, 500);
	System.out.println(lruCache.get(1));
	System.out.println(lruCache.get(2));
	System.out.println(lruCache.get(3));
	
	
		lruCache.print();
		
	}
}