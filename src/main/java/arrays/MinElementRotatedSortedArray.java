package arrays;

public class MinElementRotatedSortedArray {

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        // If the array is not rotated, the first element is the smallest
        if (nums[low] < nums[high]) {
            return nums[low];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than high element, the min is in the right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                // Otherwise, the min is in the left half (or could be mid itself)
                high = mid;
            }
        }

        // At the end of the loop, low == high and points to the minimum element
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }

}
