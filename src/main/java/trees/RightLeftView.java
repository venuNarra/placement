package trees;

/**
 * Created by eig on 06/08/17.
 */
public class RightLeftView
{
    static int max_level = 0;

    static void rightView(BinaryTree root)
    {
        max_level = 0;
        rightViewUtil(root, 1);
    }

    static void leftView(BinaryTree root)
    {
        max_level = 0;
        leftViewUtil(root, 1);
    }

    static void rightViewUtil(BinaryTree root, int level)
    {
        if (root == null)
        {
            return;
        }
        if (max_level < level)
        {
            System.out.println(root.getData());
            max_level = level;
        }
        if (root.getRight() != null)
        {
            rightViewUtil(root.getRight(), level + 1);
        }
        if (root.getLeft() != null)
        {
            rightViewUtil(root.getLeft(), level + 1);
        }
    }

    static void leftViewUtil(BinaryTree root, int level)
    {
        if (root == null)
        {
            return;
        }
        if (max_level < level)
        {
            System.out.println(root.getData());
            max_level = level;
        }
        if (root.getLeft() != null)
        {
            leftViewUtil(root.getLeft(), level + 1);
        }
        if (root.getRight() != null)
        {
            leftViewUtil(root.getRight(), level + 1);
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
        root.getRight().getRight().setRight(new BinaryTree(8));

        rightView(root);
        leftView(root);
    }
}
