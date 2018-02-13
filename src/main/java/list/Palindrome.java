/**
 *  Copyright 2014 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package list;

/**
 * @version 1.0, 23-Mar-2014
 * @author venu
 */
public class Palindrome {
	static class List {
		char data;
		List next;

		private List(char data) {
			super();
			this.data = data;
			this.next = null;
		}

	}

	private static void print(List list) {
		List localList = list;
		if (localList == null)
			return;
		while (localList.next != null) {
			System.out.print(localList.data + "->");
			localList = localList.next;
		}
		System.out.println(localList.data);
	}

	private static void insert(List list, char data) {

		if (list == null) {
			list = new List(data);
		} else {
			List localList = list;
			while (localList.next != null) {
				localList = localList.next;
			}
			localList.next = new List(data);
		}
	}

	public static void main(String[] args) {
		List list = new List('a');
		insert(list, 'b');
		insert(list, 'c');
		insert(list, 'd');
		insert(list, 'e');
		insert(list, 'e');
		insert(list, 'd');
		insert(list, 'c');
		insert(list, 'b');
		insert(list, 'a');
		print(list);
		System.out.println(isPalindrome(list));

	}

	private static boolean isPalindrome(List list) {
		if (palindromeUtil(list, list) == null)
			return true;
		return false;
	}

	private static List palindromeUtil(List left, List right) {
		if (right == null) {
			return left;
		}

		left = palindromeUtil(left, right.next);

		if (left.data == right.data)
			left = left.next;

		return left;
	}

}
