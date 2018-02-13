/**
 *  Copyright 2013 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package list;

/**
 * @version 1.0, 10-Nov-2013
 * @author venu
 */
public class DLL {
    private class Node {
        int  data;
        Node next;
        Node prev;

        Node(int data) {
            super();
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    void print(Node header) {
        Node temp = header;
        if (temp == null)
            return;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverse(Node header) {
        Node prevNode = null;
        Node currNode = header;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            if (prevNode != null)
                prevNode.prev = currNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        header = prevNode;
        print(prevNode);

    }

    public static void main(String[] args) {

        DLL dll = new DLL();
        Node header = dll.new Node(1);
        Node node2 = dll.new Node(2);
        Node node3 = dll.new Node(3);
        Node node4 = dll.new Node(4);
        header.next = node2;
        node2.prev = header;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        dll.print(header);
        dll.reverse(header);

    }
}
