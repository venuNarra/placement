package trees;

/**
 * Created by eig on 06/08/17.
 */
public class KdistanceFromNode
{
    static void kdistanceFromNode(BinaryTree root, BinaryTree n1, int k)
    {

    }

    public static void main(String[] args)
    {
        BinaryTree root = new BinaryTree(1);
        root.setLeft(new BinaryTree(2));
        root.setRight(new BinaryTree(3));
        root.getLeft().setLeft(new BinaryTree(4));
        root.getLeft().setRight(new BinaryTree(5));
        root.getRight().setLeft(new BinaryTree(6));
        root.getRight().setRight(new BinaryTree(7));
        kdistanceFromNode(root, root.getRight(), 2);
    }
}
