/* You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
Return the index of the peak element.
Your task is to solve it in O(log(n)) time complexity.

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1

Constraints:
3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array. */

package BinarySearch;

public class FindPeakIndexMountain {
    public static int findPeakIndexMountainArray(int [] nums) {
        int left = 0;
        int right = nums.length - 1;

        int peakIndex = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < nums[mid + 1]) left = mid + 1;
            else {
                peakIndex = mid;
                right = mid - 1;
            }
        }

        return peakIndex;
    }

    public static void main(String[] args) {
        int [] nums = {0,1,2,0};

        System.out.println(findPeakIndexMountainArray(nums));
    }
}
