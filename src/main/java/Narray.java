
import java.util.Stack;

/**
 * Created by eig on 02/08/17.
 */
public class Narray {

	public static void traversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.getData());
		for (Node child : root.getChilds()) {
			traversal(child);
		}
	}

	public static void traversalIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);

		while (!s.isEmpty()) {
			Node node = s.pop();
			System.out.println(node.getData());
			for (Node child : node.getChilds()) {
				s.push(child);
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node('A');
		Node root1 = new Node('B');
		Node root2 = new Node('C');
		Node root3 = new Node('D');
		Node root4 = new Node('E');
		Node root5 = new Node('F');

		root.addChild(root1); // A->B
		root1.addChild(root2);// A->B->C
		root1.addChild(root3);// A->B->C
								// \->D
		root2.addChild(root4);// A->B->C->E
								// \->D

		root3.addChild(root5);// A->B->C->E
								// \->D->F

		traversal(root);
		System.out.println("\n");
		traversalIteration(root);

	}

}
