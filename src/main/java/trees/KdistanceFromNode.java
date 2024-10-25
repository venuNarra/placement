package trees;

/**
 * Created by eig on 06/08/17.
 */
public class KdistanceFromNode {
	static int kdistanceFromNode(BinaryTree root, BinaryTree target, int k) {
		// base conditions
		if (root == null)
			return -1;
		//matches with root or k==0
		if(root==target || k==0) {
			kdistnceFromRoot(root,k);
			return 0;
		}
		int ld=kdistanceFromNode(root.getLeft(),target,k);
		
		if(ld!=-1) {
			ld++;
			if(ld==k) {
				System.out.println(root.getData());
			}else {
				kdistanceFromNode(root.getRight(),target,k-ld-1);
			}
			return ld;
		}
		int rd=kdistanceFromNode(root.getRight(),target,k);
	
		if(rd!=-1) {
			rd++;
			if(rd==k) {
				System.out.println(root.getData());
			}else {
			
				kdistanceFromNode(root.getLeft(),target,k-rd-1);
			}
			return rd;
		}
		return -1;
	}

	private static void kdistnceFromRoot(BinaryTree root, int k) {
		if(root == null) return;
		if(k==0) {
			System.out.println(root.getData());
			return;
		}
		kdistnceFromRoot(root.getLeft(),k-1);
		kdistnceFromRoot(root.getRight(),k-1);
		
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.setLeft(new BinaryTree(2));
		root.setRight(new BinaryTree(3));
		root.getLeft().setLeft(new BinaryTree(4));
		root.getLeft().setRight(new BinaryTree(5));
		root.getRight().setLeft(new BinaryTree(6));
		root.getRight().setRight(new BinaryTree(7));
		root.getRight().getRight().setRight(new BinaryTree(8));
		root.getRight().getLeft().setLeft(new BinaryTree(9));
		kdistanceFromNode(root, root.getRight().getRight(), 2);
	}
}
