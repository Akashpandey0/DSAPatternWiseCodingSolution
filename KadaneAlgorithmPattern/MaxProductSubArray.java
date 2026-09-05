// Given an integer array nums, find a subarray that has the largest product, and return the product.
// The test cases are generated so that the answer will fit in a 32-bit integer.
// Note that the product of an array with a single element is the value of that element.

// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

// Constraints:
// 1 <= nums.length <= 2 * 104
// -10 <= nums[i] <= 10
// The product of any subarray of nums is guaranteed to fit in a 32-bit integer.

package KadaneAlgorithmPattern;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int [] nums = {2,3,-2,4};
        int [] nums1 = {-2,0,-1};
        int [] nums2 = {5,4,-1,7,8};

        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
    }
    public static int maxProduct(int[] nums) {
        int minEnd = nums[0];
        int maxEnd = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int v1 = nums[i];
            int v2 = minEnd * nums[i];
            int v3 = maxEnd * nums[i];

            maxEnd = Math.max(v1, Math.max(v2, v3));
            minEnd = Math.min(v1, Math.min(v2,v3));

            result = Math.max(result, maxEnd);
        }
        return result;
    }
}
