package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eig on 06/08/17.
 */
public class SumOfAllElements
{
    static int sum(BinaryTree root)
    {
        if (root == null)
        {
            return 0;
        }
        return root.getData() + sum(root.getLeft()) + sum(root.getRight());
    }

    static int sumNR(BinaryTree root)
    {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(root);
        BinaryTree temp;
        int sum = 0;
        while (!queue.isEmpty())
        {
            temp = queue.remove();
            sum += temp.getData();
            if (temp.getLeft() != null)
            {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null)
            {
                queue.add(temp.getRight());
            }
        }
        return sum;
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
        System.out.println(sum(root));
        System.out.println(sumNR(root));
    }
}
