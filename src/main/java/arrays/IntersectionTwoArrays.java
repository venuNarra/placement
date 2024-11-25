package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionTwoArrays {

    public static String FindIntersection1(String[] strArr) {
        int[] A = Arrays.stream(strArr[0].replaceAll(" +","").split(",")).
                mapToInt(Integer::parseInt).toArray();

        int[] B = Arrays.stream(strArr[1].replaceAll(" +","").split(",")).
                mapToInt(Integer::parseInt).toArray();
        List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while( i < A.length && j < B.length){
            if( A[i] == B[j] ){
                result.add(A[i]);
                i++;
                j++;
            }else if( A[i] < B[j]){
                i++;
            }else{
                j++;
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining(","));

    }


    public static String FindIntersection(String[] strArr) {
            // Split the two arrays in the string
            String[] arr1 = strArr[0].split(", ");
            String[] arr2 = strArr[1].split(", ");

            List<String> result = new ArrayList<>();

            // Store the first array elements in a set
            Set<String> set = new HashSet<>(Arrays.asList(arr1)); //0(m)

            // Find common elements in both arrays
            for (String num : arr2) {   //0(n)
                if (set.contains(num)) {
                    result.add(num);
                }
            }

            // Return the result as a comma-separated string or "false" if empty
            return result.isEmpty() ? "false" : String.join(",", result);
        }

        public static void main(String[] args) {
            String[] strArr = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
            System.out.println(FindIntersection1(strArr)); // Output: "1,4,13"
        }


}
