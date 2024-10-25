package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eig on 06/08/17.
 */
public class MaxElement
{
    static int maxElement(BinaryTree root)
    {
        if (root == null)
        {
            return Integer.MIN_VALUE;
        }
        int leftMax = maxElement(root.getLeft());
        int rightMax = maxElement(root.getRight());
        return Math.max(Math.max(leftMax,rightMax), root.getData());
    }

    static int maxElemetNR(BinaryTree root)
    {
        int max = Integer.MIN_VALUE;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BinaryTree temp = queue.poll();
            if (max < temp.getData())
            {
                max = temp.getData();
            }
            if (temp.getLeft() != null)
            {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null)
            {
                queue.add(temp.getRight());
            }
        }
        return max;
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
        System.out.println(maxElement(root));
        System.out.println(maxElemetNR(root));
    }
}
