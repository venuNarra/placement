package trees;

/**
 * Created by eig on 06/08/17.
 */
public class KdistanceFromRoot
{
    static void kdistanceFromRoot(BinaryTree root, int k)
    {
        if (root == null)
        {
            return;
        }
        if (k == 0)
        {
            System.out.println(root.getData());
            return;
        }
        kdistanceFromRoot(root.getLeft(), k - 1);
        kdistanceFromRoot(root.getRight(), k - 1);
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
        kdistanceFromRoot(root, 2);
    }
}
