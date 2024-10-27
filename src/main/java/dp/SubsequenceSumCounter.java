package dp;

    public class SubsequenceSumCounter {
        public static int countSubsequencesSumwithK(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1; // One way to achieve sum 0: by choosing no elements

            for (int num : nums) {
                System.out.println("processing for num: " + num);
                for (int sum = target; sum >= num; sum--) {
                    dp[sum] += dp[sum - num];
                }
                for(int i:dp) {
                    System.out.print(i + ",");
                }
                System.out.println();

            }
            for(int i:dp)
            {
                System.out.print(i + ",");
            }
            System.out.println();

            return dp[target];
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 7, 5};
            int target = 12;

            int count = countSubsequencesSumwithK(nums, target);
            System.out.println("Number of subsequences with sum " + target + ": " + count);
        }
    }

