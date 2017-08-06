package trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eig on 06/08/17.
 */
public class Traversal
{
    static void inorder(BinaryTree root)
    {
        if (root == null)
        {
            return;
        }
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

    static void inoderNR(BinaryTree root)
    {
        Stack<BinaryTree> s = new Stack<BinaryTree>();
        while (true)
        {
            while (root != null)
            {
                s.push(root);
                root = root.getLeft();
            }
            if (s.isEmpty())
            {
                break;
            }
            root = s.pop();
            System.out.println(root.getData());
            root = root.getRight();


        }
    }


    static void preOrder(BinaryTree root)
    {
        if (root == null)
        {
            return;
        }
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    static void preOrderNR(BinaryTree root)
    {
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        while (true)
        {
            while (root != null)
            {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty())
            {
                break;
            }
            root = stack.pop();
            root = root.getRight();
        }
    }

    static void postOrder(BinaryTree root)
    {
        // left, right, root.data
        if (root == null)
        {
            return;
        }
        if (root.getLeft() != null)
        {
            postOrder(root.getLeft());
        }
        if (root.getRight() != null)
        {
            postOrder(root.getRight());
        }
        System.out.println(root.getData());
    }

    static void postOrderNR(BinaryTree root)
    {
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        while (true)
        {
            while (root != null)
            {
                root.setData(-root.getData());
                stack.push(root);
                root = root.getLeft();
            }

            if (stack.isEmpty())
            {
                break;
            }

            root = stack.pop();
            if (root.getData() < 0)
            {
                root.setData(-root.getData());
                stack.push(root);
                root = root.getRight();
            }
            else
            {
                System.out.println(root.getData());
                root = null;
            }
        }
    }

    static void leverlOrder(BinaryTree root)
    {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BinaryTree temp=queue.remove();
            System.out.println(temp.getData());
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

    public static void main(String[] args)
    {
        BinaryTree root = new BinaryTree(1);
        root.setLeft(new BinaryTree(2));
        root.setRight(new BinaryTree(3));
        root.getLeft().setLeft(new BinaryTree(4));
        root.getLeft().setRight(new BinaryTree(5));
        root.getRight().setLeft(new BinaryTree(6));
        root.getRight().setRight(new BinaryTree(7));
//        inorder(root);
//        System.out.println();
//        inoderNR(root);
//        System.out.println();
//        preOrder(root);
//        System.out.println();
//        preOrderNR(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        postOrderNR(root);
//        System.out.println();
        leverlOrder(root);
    }
}
