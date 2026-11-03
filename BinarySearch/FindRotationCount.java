/* Given an increasing sorted rotated array arr[] of distinct integers. The array is right-rotated k times. Find the value of k.

Examples:
Input: arr[] = [5, 1, 2, 3, 4]
Output: 1
Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.

Input: arr = [1, 2, 3, 4, 5]
Output: 0
Explanation: The given array is not rotated.

Input: arr = [6, 9, 2, 4]
Output: 2
Explanation: The original array is [2, 4, 6, 9] and we get the above array after two rotations.

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 107 */

package BinarySearch;

public class FindRotationCount {
    public static int findKRotation(int arr[]) {
        // Code here
        int left = 0;
        int right = arr.length - 1;

        int idx = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] > arr[arr.length - 1]) left = mid + 1;
            else {
                idx = mid;
                right = mid - 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};

        System.out.println(findKRotation(arr));
    }
}
