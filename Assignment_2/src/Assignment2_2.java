/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

public class Assignment2_2 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    public static int maxSubArray(int[] nums) {
    	// create global max and record
    	int max = nums[0];
        if (nums.length == 1) return max;
        // create a storing array, for each index storages the sum of nums[index] and prev all
        int[] sums = new int[nums.length];
        // add base rule, the first sum is always nums[0] itself
        sums[0] = nums[0];
        // after storing the first sum, there are two conditions for following adding rules
        // one: itself
        // two: add previous sum
        // but if prev < 0, sum must be smaller than itself
        for (int i = 1; i < nums.length; i++) {
        	if (sums[i - 1] < 0) {
        		sums[i] = nums[i];
        	}
        	else {
        		sums[i] = nums[i] + sums[i - 1];
        	}
        	if (sums[i] > max) max = sums[i];
        }
        return max;
    }

    public static void main(String[] args) {
    	int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}