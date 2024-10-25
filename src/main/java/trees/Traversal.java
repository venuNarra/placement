package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eig on 06/08/17.
 */
public class Traversal
{
    static void inorder(BinaryTree root)
    {
        // left, data, right
        if (root == null)
            return;
        inorder(root.getLeft());
        System.out.println(root.getData());
        inorder(root.getRight());
    }

    static void inoderNR(BinaryTree root)
    {
        if( root == null )
            return;
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree currentNode = root;

        // Traverse the tree
        while ( !stack.isEmpty() || currentNode != null )
        {
            // Reach the left most subtree
            while (currentNode != null)
            {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }
            // process the node at the top of the stack
            currentNode = stack.pop();
            System.out.println(currentNode.getData());

            // Move to right subtree
            currentNode = currentNode.getRight();

        }
    }


    static void preOrder(BinaryTree root)
    {
        // data, left, right
        if (root == null)
            return;
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    static void preOrderNR(BinaryTree root)
    {
        if(root == null)
            return;
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // pop the top node and print its value
            BinaryTree currentNode = stack.pop();
            System.out.println(currentNode.getData());

            // Trick: push the right first, so that left processed first
            if(currentNode.getRight() != null)
                stack.push(currentNode.getRight());

            if(currentNode.getLeft() != null)
                stack.push(currentNode.getLeft());

        }
    }

    static void postOrder(BinaryTree root)
    {
        // left, right, data
        if (root == null)
        {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getData());
    }

    static void postOrderNR(BinaryTree root)
    {
        if(root == null)
            return;
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();

        stack1.push(root);
        while ( !stack1.isEmpty() )
        {
            BinaryTree currentNode = stack1.pop();
            stack2.push(currentNode);

            if(currentNode.getLeft() != null)
                stack1.push(currentNode.getLeft());

            if(currentNode.getRight() != null)
                stack1.push(currentNode.getRight());

        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().getData());
        }
    }

    static void levelOrder(BinaryTree root)
    {
        if(root == null)
            return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            BinaryTree currentNode=queue.poll();
            System.out.println(currentNode.getData());
            if (currentNode.getLeft() != null)
            {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null)
            {
                queue.add(currentNode.getRight());
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
        inorder(root);
        System.out.println();
        inoderNR(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        preOrderNR(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        postOrderNR(root);
        System.out.println();
        levelOrder(root);
    }
}
