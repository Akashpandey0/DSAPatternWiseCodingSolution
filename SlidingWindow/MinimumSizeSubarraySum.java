// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum
// is greater than or equal to target. If there is no such subarray, return 0 instead.

// Example 1:

// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.
// Example 2:

// Input: target = 4, nums = [1,4,4]
// Output: 1
// Example 3:

// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0

package SlidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int [] nums = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int [] nums) {
        int low = 0, right;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(right = 0; right < nums.length; right++) {
            sum = sum + nums[right];

            while(sum >= target) {
                minLen = Math.min(minLen, right - low + 1);
                sum -= nums[low];
                low++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
