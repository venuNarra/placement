package dp;

import java.util.*;

class Solution {
    public static List<List<Integer>> subarraySumOptimised(int[] nums, int k) {
        int count=0;

        List<List<Integer>> result = new ArrayList<>();
        // key = sum & values = index of the array
        Map<Integer,Integer> map = new TreeMap<>();
        int sum=0;
        map.put(0,0);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count++;
                List<Integer> subarray= new ArrayList<>();
                System.out.println("Solution: " +map.get(sum-k)+","+i);
                for(int j=map.get(sum-k); j<=i;j++)
                    subarray.add(nums[j]);
                result.add(subarray);
            }
            map.put(sum,i+1);
        }
        return result;
    }

    public static List<Integer> firstsubarraySum(int[] nums, int k) {
        int count=0;

        // key = sum & values = index of the array
        Map<Integer,Integer> map = new TreeMap<>();
        int sum=0;
        map.put(0,0);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count++;
                List<Integer> subarray= new ArrayList<>();
                System.out.println("Solution: " +map.get(sum-k)+","+i);
                for(int j=map.get(sum-k); j<=i;j++)
                    subarray.add(nums[j]);
                return subarray;
            }
            map.put(sum,i+1);
        }
        return new ArrayList<>();
    }

    public static List<Integer> longestsubarraySum(int[] nums, int k) {
        int maxLength=0;
        List<Integer> result= new ArrayList<>();
        // key = sum & values = index of the array
        Map<Integer,Integer> map = new TreeMap<>();
        int sum=0;
        map.put(0,0);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                List<Integer> subarray= new ArrayList<>();
                System.out.println("Solution: " +map.get(sum-k)+","+i);
                for(int j=map.get(sum-k); j<=i;j++)
                    subarray.add(nums[j]);
                if(maxLength <= (i- map.get(sum-k))) {
                    result = subarray;
                    maxLength = i- map.get(sum-k);
                }
            }
            map.put(sum,i+1);
        }
        return result;
    }

    public static List<Integer> lowestsubarraySum(int[] nums, int k) {
        int minLength=0;
        List<Integer> result= new ArrayList<>();
        // key = sum & values = index of the array
        Map<Integer,Integer> map = new TreeMap<>();
        int sum=0;
        map.put(0,0);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                List<Integer> subarray= new ArrayList<>();
                System.out.println("Solution: " +map.get(sum-k)+","+i);
                for(int j=map.get(sum-k); j<=i;j++)
                    subarray.add(nums[j]);
                if(minLength >= (i- map.get(sum-k))) {
                    result = subarray;
                    minLength = i- map.get(sum-k);
                }
            }
            map.put(sum,i+1);
        }
        return result;
    }

    public static int subarraySumBruteforce(int[] nums, int k) {
        int count=0;
        int sum=0;
        for(int i=0;i< nums.length; i++){ // starting point
            sum=0;
            for(int j=i;j< nums.length;j++){     // O(n^2)
                sum+=nums[j];
                if(sum==k)   // result criteria (i & j)
                    count++;
            }
        }
        return count;
    }

    public static int subarraySumUsingSlidingWindow(int[] nums, int k) {
        int count=0;
        int sum=0;
        int startIndex=0;
        for(int i=0;i<nums.length;i++){
             sum+=nums[i];
             if(sum==k){
                 count++;
                 System.out.print(startIndex+","+i);
                 System.out.println();
             }
             while(sum > k && startIndex <= i){
                 sum=sum-nums[startIndex];
                 startIndex++;
                 if(sum==k){
                     count++;
                     System.out.print(startIndex+","+i);
                     System.out.println();
                 }
             }
         }
        return count;
    }
    public static int subarraySumUsingPreSumCalculator(int[] nums, int k) {
        int count=0;

         int[] sumArray=new int[nums.length+1];
         for(int i=0;i<nums.length; i++)
             sumArray[i+1]=sumArray[i]+nums[i];

         for(int i=0;i<sumArray.length; i++)
             System.out.print(sumArray[i]+",");

         System.out.println();

         for(int i=0;i<sumArray.length;i++){
             for(int j=i;j<sumArray.length;j++)
                 if(sumArray[j]-sumArray[i] == k){  // O(n^2)
                     count++;
                     System.out.print(i+","+(j-1));
                     System.out.println();
                 }
         }
        return count;
    }
    public static void main(String[] args) {
        int[] nums= { 1, 4, 0, 0, 3, 10, 5, 2 };
        int k=5;
        System.out.println(subarraySumBruteforce(nums, k));
        System.out.println(subarraySumUsingPreSumCalculator(nums, k));
        System.out.println(subarraySumUsingSlidingWindow(nums, k));
        System.out.println("Total solutions:"+subarraySumOptimised(nums, k));
        System.out.println("firstsubarraySum:" + firstsubarraySum(nums,k));
        System.out.println("longestsubarraySum:" + longestsubarraySum(nums,k));
        System.out.println("lowestsubarraySum:" + lowestsubarraySum(nums,k));

    }
}