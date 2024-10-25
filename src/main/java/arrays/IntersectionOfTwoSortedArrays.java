package arrays;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {
    public static ArrayList<Integer> intersectionOfArrays(int[] A, int[] B) {
        ArrayList<Integer> result= new ArrayList<>();
        int i=0,j=0;
        while(i< A.length && j < B.length) {
            if(A[i] > B[j])
                j++;
            else if( A[i] < B[j])
                i++;
            else{
                result.add(A[i]);
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A= {1,2,3,3,4,5,6,7};
        int[] B= {3,3,4,4,5,8};
        System.out.println(intersectionOfArrays(A,B));
    }
}
