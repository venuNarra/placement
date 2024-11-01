package trees;


/**
 * Created by eig on 06/08/17.
 */
public class MaxSumPath
{
    static int max_value = Integer.MIN_VALUE;
    static int[] max_path;

    static int maxSumPath(BinaryTree root)
    {

        int[] path = new int[100];
        maxSumPathUtil(root, path, 0);
        for (int i = 0; i < max_path.length; i++)
        {
            if (max_path[i] != 0)
            {
                System.out.println(max_path[i]);
            }
        }
        return max_value;
    }

    static void maxSumPathUtil(BinaryTree root, int[] path, int pathLength)
    {
        if (root == null)
        {
            return;
        }

        path[pathLength] = ((pathLength - 1 >= 0) ? path[pathLength - 1] : 0) + root.getData();
        if (root.getLeft() == null && root.getRight() == null)
        {
            if (max_value < path[pathLength])
            {
                max_value = path[pathLength];
                
                max_path = path;

            }
        }
        maxSumPathUtil(root.getLeft(), path, pathLength + 1);
        maxSumPathUtil(root.getRight(), path, pathLength + 1);

    }
    static int maxSumPathAlt(BinaryTree root) {
    	if(root==null) 
    		return 0;

        // Recursively calculate the max sum for the left and right subtrees
        int left=maxSumPathAlt(root.getLeft());
    	int right=maxSumPathAlt(root.getRight());

        // Return the current node's value plus the larger of the left or right subtree sums
        return root.getData()+Math.max(left, right);
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
       // root.getRight().getRight().setLeft(new BinaryTree(8));

        System.out.println(maxSumPath(root));
        System.out.println(maxSumPathAlt(root));
    }
}
