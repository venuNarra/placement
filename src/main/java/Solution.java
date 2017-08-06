

/**
 * Created by eig on 02/08/17.
 */
/*
 * Complete the function below.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution
{

    /**
     * Created by eig on 02/08/17.
     */
    public static class BST
    {
        private int data;
        private BST left;
        private BST right;

        public BST(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public int getData()
        {
            return data;
        }

        public void setData(int data)
        {
            this.data = data;
        }

        public BST getLeft()
        {
            return left;
        }

        public void setLeft(BST left)
        {
            this.left = left;
        }

        public BST getRight()
        {
            return right;
        }

        public void setRight(BST right)
        {
            this.right = right;
        }
    }
    static void createBST(int[] keys)
    {

        int counter = 0;
        BST root = null;
        for (int key : keys)
        {
            if (root != null)
            {
                insert(root, key);
            }
            else
            {
                root = new BST(key);
            }
        }
    }

    static void insert(BST root, int key)
    {
        System.out.println("called");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int _keys_size = 0;
        _keys_size = Integer.parseInt(in.nextLine().trim());
        int[] _keys = new int[_keys_size];
        int _keys_item;
        for (int _keys_i = 0; _keys_i < _keys_size; _keys_i++)
        {
            _keys_item = Integer.parseInt(in.nextLine().trim());
            _keys[_keys_i] = _keys_item;
        }

        createBST(_keys);

    }
}


