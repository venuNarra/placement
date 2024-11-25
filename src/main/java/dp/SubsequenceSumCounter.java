package dp;

    public class SubsequenceSumCounter {

        public static int subsetsSum(int[] nums, int target){
            int[][] M=new int[nums.length][target+1];   // #of ways to achieve target using i+1 elements
            // Initialise the base cases
            for(int i=0;i<nums.length;i++)
                M[i][0]=1;
            M[0][nums[0]]=1;
            for(int i=1;i< nums.length;i++)
                for(int j=1;j<=target;j++)
                    if(j-nums[i] >=0)
                        M[i][j] = M[i-1][j] + M[i-1][j-nums[i]];
                    else
                        M[i][j] = M[i-1][j];

            for(int i=0;i< nums.length;i++) {
                for (int j = 0; j <= target; j++)
                    System.out.print(M[i][j] + " ");
                System.out.println();
            }

            return M[nums.length-1][target];
        }

        public static int subsetsSumSpaceOptimised(int[] nums, int target){
            int[] prev = new int[target+1];
            int[] curr = new int[target+1];

            // Initialise the base cases
            prev[0]=1;
            curr[0]=1;

            if(nums[0] <= target) {
                prev[nums[0]] = 1;
            }

            //iterate over the loop
            for(int i=1;i< nums.length;i++) {
                for (int sum = 0; sum <= target; sum++) {
                    if (sum - nums[i] >= 0)
                        curr[sum] = prev[sum] + prev[sum - nums[i]];
                    else
                        curr[sum] = prev[sum];
                }
                System.arraycopy(curr, 0, prev, 0, target + 1);
                for(int index:prev) {
                    System.out.print(index + ",");
                }
                System.out.println();
            }
            return prev[target];
        }




        public static int countSubsequencesSumwithK(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1; // One way to achieve sum 0: by choosing no elements

            for (int num : nums) {
                System.out.println("processing for num: " + num);
                for (int sum = target; sum >= num; sum--) {
                    dp[sum] = dp[sum] + dp[sum - num];
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
            int target = 10;

            System.out.println(subsetsSum(nums,target));
            int count = countSubsequencesSumwithK(nums, target);
            System.out.println("Number of subsequences with sum " + target + ": " + count);
            System.out.println(subsetsSumSpaceOptimised(nums,target));


        }
    }

