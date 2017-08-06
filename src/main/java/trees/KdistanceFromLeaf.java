package trees;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by eig on 06/08/17.
 */
public class KdistanceFromLeaf
{
    static void kdistanceFromLeaf(BinaryTree root, int k)
    {
        int[] path = new int[100];
        Boolean[] visited = new Boolean[100];
        kdistanceFromLeafUtil(root, k, path, 0, visited);
    }

    static void kdistanceFromLeafUtil(BinaryTree root, int k, int[] path, int pathLength, Boolean[] visited)
    {
        if (root == null)
        {
            return;
        }
        path[pathLength] = root.getData();
        visited[pathLength] = false;
        if (root.getLeft() == null && root.getRight() == null && (pathLength - k) >= 0 && visited[pathLength - k] == false)
        {
            System.out.println(path[pathLength - k]);
            visited[pathLength - k] = true;
        }
        else
        {
            kdistanceFromLeafUtil(root.getLeft(), k, path, pathLength + 1, visited);
            kdistanceFromLeafUtil(root.getRight(), k, path, pathLength + 1, visited);
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
        kdistanceFromLeaf(root, 1);
    }
}
