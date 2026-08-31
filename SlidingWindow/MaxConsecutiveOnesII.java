// Description:Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
// Example 1:Input: nums = [1,0,1,1,0]
// Output: 4
// Explanation: Flipping the first 0 turns the array into [1,1,1,1,0], which has 4 consecutive 1s.

// Example 2:Input: nums = [1,0,1,1,0,1]
// Output: 4
// Explanation: Flipping the first 0 gives [1,1,1,1,0,1] (4 consecutive 1s). Flipping the second 0 gives [1,0,1,1,1,1] (4 consecutive 1s).
// The maximum length is 4.

// Constraints1 <= nums.length <= 10^5nums[i] is either 0 or 1

package SlidingWindow;

public class MaxConsecutiveOnesII {
    public static void main(String[] args) {
        int nums[] = {1,0,1,1,0};

        System.out.println(maxConsecutiveOnesII(nums));
    }

    public static int maxConsecutiveOnesII(int [] nums) {
        int left = 0, right;
        int maxLen = 0;
        int zeroCnt = 0;

        for(right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeroCnt++;

            while(zeroCnt > 1) {
                if (nums[left] == 0) {
                    zeroCnt--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
