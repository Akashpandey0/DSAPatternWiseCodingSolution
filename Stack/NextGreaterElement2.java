// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

// Example 1:
// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.

// Example 2:
// Input: nums = [1,2,3,4,3]
// Output: [2,3,4,-1,4]

// Constraints:
// 1 <= nums.length <= 104
// -109 <= nums[i] <= 109

package Stack;

import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int [] nums = {1,2,1};
        int [] nums1 = {1,2,3,4,3};

        for(int num : nextGreaterElements(nums)) {
            System.out.print(num + ", ");
        }

        System.out.println();
        System.out.println("-------------");

        for(int num: nextGreaterElements(nums1))
            System.out.print(num + ",");
    }
    public static int[] nextGreaterElements(int[] nums) {
        int res [] = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 2 * nums.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i % nums.length]) st.pop();

            if(st.isEmpty()) res[i % nums.length] = -1;
            else res[i % nums.length] = st.peek();

            st.push(nums[i % nums.length]);
        }
        return res;
    }
}
