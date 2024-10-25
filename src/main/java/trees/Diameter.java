package trees;

/**
 * Created by eig on 06/08/17.
 */
public class Diameter
{
    static int diameter(BinaryTree root)
    {
        if (root == null)
        {
            return 0;
        }
        int ld = diameter(root.getLeft());
        int rd = diameter(root.getRight());
        int lh = Height.height(root.getLeft());
        int rh = Height.height(root.getRight());

        return Math.max(Math.max(ld, rd), 1 + lh + rh);
    }

    static int[] diameterOpt(BinaryTree root)
    {
        // result[0] = diameter, result[1] = height
        int[] result = new int[]{0, 0};
        if (root == null)
        {
            return result;
        }
        int[] ld = diameterOpt(root.getLeft());
        int[] rd = diameterOpt(root.getRight());
        result[0] = Math.max(ld[1] + rd[1] + 1, Math.max(ld[0], rd[0]));
        result[1] = Math.max(ld[1], rd[1]) + 1;
        return result;
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

        System.out.println(diameter(root));
        System.out.println(diameterOpt(root)[0]);
        System.out.println(diameterOpt(root)[1]);
    }
}
