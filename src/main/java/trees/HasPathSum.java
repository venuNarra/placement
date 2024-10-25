package trees;

/**
 * Created by eig on 06/08/17.
 */
public class HasPathSum
{
    static Boolean hasPathSum(BinaryTree root, int sum)
    {
        if (root == null)
        {
            return false;
        }
        if ( root.getLeft() == null && root.getRight() == null)
        {
            return ( sum == root.getData());
        }
        int remainingSum = sum - root.getData();
        return hasPathSum(root.getLeft(), remainingSum) || hasPathSum(root.getRight(), remainingSum);

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
        System.out.println(hasPathSum(root, 9));
    }
}
