package trees;

/**
 * Created by eig on 06/08/17.
 */
public class PrintPaths
{
    static void printPaths(BinaryTree root)
    {
        int[] path = new int[100];
        printPathsUtil(root, path, 0);
    }

    static void printPathsUtil(BinaryTree root, int[] path, int pathLength)
    {
        if (root == null)
        {
            return;
        }
        path[pathLength] = root.getData();
        if (root.getLeft() == null && root.getRight() == null)
        {
            for (int i = 0; i <= pathLength; i++)
            {
                System.out.println(path[i]);
            }
            System.out.println();
        }
        printPathsUtil(root.getLeft(), path, pathLength + 1);
        printPathsUtil(root.getRight(), path, pathLength + 1);
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
        printPaths(root);
    }
}
