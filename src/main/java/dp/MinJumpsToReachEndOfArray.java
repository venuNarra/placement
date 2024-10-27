package dp;

public class MinJumpsToReachEndOfArray {
        public static int minJumps(int[] nums) {
            // creation of temp arrays
            int[] minJumps= new int[nums.length];
            int[] jumpsFrom = new int[nums.length];
            // initialisations
            minJumps[0]= 0;
            jumpsFrom[0]=-1;

            //process the conditions
            for(int i=1;i<minJumps.length;i++){
                minJumps[i] = Integer.MAX_VALUE; // assign the values
                for(int j=0;j<i;j++){
                    // Check if index j can jump to or beyond index i
                    if(j+ nums[j] >= i && minJumps[j] != Integer.MAX_VALUE){
                        if(minJumps[j]+1 < minJumps[i]){
                            minJumps[i] = minJumps[j]+1;
                            jumpsFrom[i] = j;
                        }

                    }
                }
            }

            // Debug output to show the min jumps required for each index
            for(int jump: minJumps)
                System.out.print(jump+",");
            System.out.println();

            // Debug output to show the index each jump came from
            for(int jumpfrom: jumpsFrom)
                System.out.print(jumpfrom+",");
            System.out.println();
            // Return the minimum jumps needed to reach the last index
            return minJumps[nums.length - 1] == Integer.MAX_VALUE ? -1 :minJumps[nums.length-1];
        }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(nums));
    }
}
