package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eig on 06/08/17.
 */
public class Height
{

    static int height(BinaryTree root)
    {
        if (root == null)
        {
            return 0;
        }
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    static int heightLevelOrder(BinaryTree root)
    {
        if (root == null)
        {
            return 0;
        }
        int level = 0;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty())
        {
            BinaryTree temp = queue.poll();
            if (temp == null)
            {
                level++;
                if (!queue.isEmpty())
                {
                    queue.add(null);
                }
            }
            else
            {
                if (temp.getLeft() != null)
                {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() != null)
                {
                    queue.add(temp.getRight());
                }
            }
        }
        return level;
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

        System.out.println(height(root));
        System.out.println(heightLevelOrder(root));
    }
}
