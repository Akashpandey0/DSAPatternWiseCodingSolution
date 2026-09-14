// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

// Constraints:
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107

package PrefixSum;

import java.util.HashMap;
import java.util.Map;
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int [] arr1 = {1,1,1};
        int [] arr2 = {1,2,3};

        System.out.println(subarraySum(arr1,2));
        System.out.println(subarraySum(arr2,3));
    }

    public static int subarraySum(int [] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int seen = sum - k;
            if(map.containsKey(seen)) res += map.get(seen);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}