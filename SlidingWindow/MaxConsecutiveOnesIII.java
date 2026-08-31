// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

// Constraints:

// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
// 0 <= k <= nums.length

package SlidingWindow;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}; int k = 3;

        System.out.println(maxConsecutiveOnesIII(nums, k));
    }

    public static int maxConsecutiveOnesIII(int [] nums, int k) {
        int left = 0, right;
        int maxLen = 0;
        int zeroCnt = 0;

        for(right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeroCnt++;

            while(zeroCnt > k) {
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
