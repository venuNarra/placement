package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eig on 06/08/17.
 */
public class SearchBinaryTree
{

    static Boolean search(BinaryTree root, int data)
    {
        if (root == null)
        {
            return false;
        }
        if (root.getData() == data)
        {
            return true;
        }
        if (search(root.getLeft(), data))  // If its find in the left subtree then return it.
        {
            return true;
        }
        else
        {
            return search(root.getRight(), data);
        }
    }


    static Boolean searchNR(BinaryTree root, int data)
    {
        if (root == null)
        {
            return false;
        }
        //Queue<BinaryTree> queue = new LinkedList<>();
        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BinaryTree temp = queue.poll();
            if (temp.getData() == data)
            {
                return true;
            }

            // add left & right childs to the queue if exists
            if (temp.getLeft() != null)
            {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null)
            {
                queue.add(temp.getRight());
            }
        }
        return false;

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
        System.out.println(search(root, 7));
        System.out.println(searchNR(root, 7));

    }
}
