package trees;

/**
 * Created by eig on 06/08/17.
 */
public class LCA
{
    static BinaryTree lca(BinaryTree root, BinaryTree n1, BinaryTree n2)
    {
        if (root == null)
        {
            return root;
        }
        if (root == n1 || root == n2)
        {
            return root;
        }
        BinaryTree left = lca(root.getLeft(), n1, n2);
        BinaryTree right = lca(root.getRight(), n1, n2);
        if (left != null && right != null)
        {
            return root;
        }
        if (left != null)
        {
            return left;
        }

        return right;

    }

    static void inorder(BinaryTree root)
    {
        if (root.getLeft() != null)
        {
            inorder(root.getLeft());
        }
        System.out.println(root.getData());
        if (root.getRight() != null)
        {
            inorder(root.getRight());
        }
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
        inorder(root);
        System.out.println(lca(root, root.getLeft().getRight(), root.getRight().getRight()).getData());
    }
}
