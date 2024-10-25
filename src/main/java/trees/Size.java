package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eig on 06/08/17.
 */
public class Size
{
    static int size(BinaryTree root)
    {
        if (root == null)
        {
            return 0;
        }
        return size(root.getLeft()) + size(root.getRight()) + 1;
    }

    static int sizeNR(BinaryTree root)
    {
        int size = 0;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            size++;
            BinaryTree temp = queue.remove();
            if (temp.getLeft() != null)
            {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null)
            {
                queue.add(temp.getRight());
            }
        }
        return size;
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
        System.out.println(size(root));
        System.out.println(sizeNR(root));
    }
}
