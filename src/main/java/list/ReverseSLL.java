/**
 *  Copyright 2013 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package list;

/**
 * @version 1.0, 08-Nov-2013
 * @author venu
 */
public class ReverseSLL {

	Node reverse(Node header) {
		Node curr = header;
		Node next;
		Node prev = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;

	}

	Node reverseRecur(Node header) {
		if (header == null)
			return null;
		if (header.next == null)
			return header;
		Node curr = header;
		Node prev = null;
		Node next = curr.next;
		header = reverseRecur(next);
		next.next = curr;
		curr.next = prev;
		return header;
	}

	Node reverseK(Node header,int k) {
		if (header == null || header.next == null)
			return header;
		Node curr=header;
		Node prev=null;
		Node next;
		int count=0;
		while(curr!=null && count<k) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			count++;
			
		}
		header.next=reverseK(curr,k);
		return prev;
	}
	
	Node reverseAltK(Node header,int k){
		if(header==null || header.next==null)
			return header;
		Node curr=header;
		Node prev=null;
		Node next;
		int count=0;
		while(curr!=null && count<k) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			count++;
		}
		header.next=curr;
		count=0;
		while(count < (k-1)) {
			curr=curr.next;
			count++;
		}
		if(curr!=null)
			curr.next=reverseAltK(curr.next, k);
		return prev;
	}

	void print(Node header) {
		Node temp = header;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReverseSLL obj = new ReverseSLL();
		Node header = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		header.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		obj.print(header);
		header=obj.reverseAltK(header,2);
		//header = obj.reverseRecur(header);
		obj.print(header);
		//obj.print(obj.reverse(header));

	}

}
