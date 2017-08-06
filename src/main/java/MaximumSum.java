/**
 * Created by eig on 02/08/17.
 */

//Given an array of Ints find a maximum sum of non adjacent elements.
//for ex. arr = [1,0,3,9,2] then ans would be 10 = 1 + 9 (non adjacent element)

//Sum: 1,1,4,10,10
//  Max(Sum[i-2]+A[i], Sum[i-1])


public class MaximumSum
{

    static int maxSum(int[] arr)
    {
        int[] sum = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            sum[i] = Math.max((((i - 2) >= 0) ? sum[i - 2] : 0) + arr[i], (i - 1) >= 0 ? sum[i - 1] : 0);

        }
        return sum[arr.length - 1];
    }

    public static void main(String[] args)
    {
        int[] arr = {1,0,3,9,2};
        System.out.println(maxSum(arr));
    }
}
