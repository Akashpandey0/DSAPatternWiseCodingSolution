// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

// Example 1:
// Input: nums = [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

// Example 2:
// Input: nums = [0,1,0]
// Output: 2
// Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

// Example 3:
// Input: nums = [0,1,1,1,1,1,0,0,0]
// Output: 6
// Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.

// Constraints:
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.

package PrefixSum;

import java.util.HashMap;
import java.util.Map;
public class ContiguousArray {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1})); // 2
        System.out.println(findMaxLength(new int[]{0, 1, 0})); // 2
        System.out.println(findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0})); // 6
    }
    public static int findMaxLength(int [] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int zero = 0;
        int one = 0;
        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zero++;
            else one++;

            int diff = zero - one;
            if(diff == 0) res = Math.max(res, i + 1);
            if(!map.containsKey(diff)) map.put(diff, i);
            else {
                int idx = map.get(diff);
                res = Math.max(res, i - idx);
            }
        }
        return res;
    }
}
