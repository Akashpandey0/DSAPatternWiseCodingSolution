/* Given a sorted array arr[] and a number target, find the number of occurrences of target in given array.

Examples:

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.

Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.

Constraints:
1 ≤ arr.size(), arr[i], target ≤ 106 */

package BinarySearch;

public class CountOccurencesInSorted {
    public static int countFreq(int[] nums, int target) {
        int first = findFirst(nums, target);
        if(first == -1) return 0;

        int last = findLast(nums, target);

        return (last - first + 1);
    }

    public static int findFirst(int [] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

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
        return first;
    }

    public static int findLast(int [] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int last = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else {
                last = mid;
                left = mid + 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int [] nums = {1, 1, 2, 2, 2, 2, 3};

        System.out.println(countFreq(nums, 2));
    }
}
