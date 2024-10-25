package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eig on 06/08/17.
 */
public class ReversingLevelOrder
{
    static void reverseLevelOrder(BinaryTree root)
    {
        Queue<BinaryTree> queue = new LinkedList<>();
        Stack<BinaryTree> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BinaryTree temp = queue.poll();
            if (temp.getRight() != null)
            {
                queue.add(temp.getRight());
            }
            if (temp.getLeft() != null)
            {
                queue.add(temp.getLeft());
            }
            stack.push(temp);
        }

        while (!stack.isEmpty())
        {
            System.out.println(stack.pop().getData());
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
        reverseLevelOrder(root);

    }
}
