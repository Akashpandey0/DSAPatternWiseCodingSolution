/* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 */

package BinarySearch;

public class FindFirstAndLastPositionInArray {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // To find first pos(lowerbound)
        int first = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else {
                first = mid;
                right = mid - 1;
            }
        }

        if(first == -1) return new int[]{-1, -1};

        // To find last pos(upperbound)
        int last = -1;
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else {
                last = mid;
                left = mid + 1;
            }
        }

        int res[] = new int [2];

        res[0] = first;
        res[1] = last;

        return res;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};

        int [] res = searchRange(nums, 8);

        for(int i: res) System.out.print(i + " ");
    }
}
