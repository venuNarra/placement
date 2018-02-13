package trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class TopBottomView {

	public class QNode {
		BinaryTree node;
		int hd;

		public QNode(BinaryTree node, int hd) {
			super();
			this.node = node;
			this.hd = hd;
		}

		public BinaryTree getNode() {
			return node;
		}

		public void setNode(BinaryTree node) {
			this.node = node;
		}

		public int getHd() {
			return hd;
		}

		public void setHd(int hd) {
			this.hd = hd;
		}

	}

	public void topView(BinaryTree root) {
		Queue<QNode> queue = new LinkedList<QNode>();
		Set<Integer> set = new HashSet<Integer>();
		queue.add(new QNode(root, 0));
		while (!queue.isEmpty()) {
			QNode temp = queue.poll();
			BinaryTree node = temp.getNode();
			int hd = temp.hd;
			if (!set.contains(hd)) {
				set.add(hd);
				System.out.println(node.getData());
			}
			if (node.getLeft() != null) {
				queue.add(new QNode(node.getLeft(), hd - 1));
			}
			if (node.getRight() != null) {
				queue.add(new QNode(node.getRight(), hd + 1));
			}

		}
		System.out.println(set);
	}

	public void bottomView(BinaryTree root) {
		Queue<QNode> queue = new LinkedList<QNode>();
		queue.add(new QNode(root, 0));
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (!queue.isEmpty()) {
			QNode temp = queue.poll();
			BinaryTree node = temp.getNode();
			int hd = temp.getHd();
			map.put(hd, node.getData());
			if (node.getLeft() != null)
				queue.add(new QNode(node.getLeft(), hd - 1));
			if (node.getRight() != null)
				queue.add(new QNode(node.getRight(), hd + 1));
		}
		System.out.println(map);
	}

	public static void main(String[] args) {
		TopBottomView test = new TopBottomView();
		BinaryTree root = new BinaryTree(1);
		root.setLeft(new BinaryTree(2));
		root.setRight(new BinaryTree(3));
		root.getLeft().setLeft(new BinaryTree(4));
		root.getLeft().setRight(new BinaryTree(5));
		root.getRight().setLeft(new BinaryTree(6));
		root.getRight().setRight(new BinaryTree(7));
		// root.getRight().getRight().setRight(new BinaryTree(8));

	//	test.topView(root);
		test.bottomView(root);

	}
}
