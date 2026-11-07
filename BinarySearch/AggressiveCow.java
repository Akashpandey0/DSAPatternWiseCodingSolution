/* Given an integer array arr[], which denotes the positions of stalls. All the positions are distinct. There are k aggressive cows.

Assign the cows to the stalls such that the minimum distance between any two cows is maximized.

Examples:

Input: arr[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at arr[0], the second at arr[2], and the third at arr[3]. The minimum distance between any two cows is 3 (between arr[0] and arr[2]), which is the maximum possible among all valid arrangements.
Input: arr[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at arr[0], the second at arr[1], and the third at arr[4]. In this arrangement, the minimum distance between any two cows is 4 (between arr[1] and arr[4]), which is the maximum possible among all valid arrangements.
Constraints:

arr.size() ≤ 106
0 ≤ arr[i] ≤ 108
2 ≤ k ≤ arr.size() */

package BinarySearch;

import java.util.Arrays;

public class AggressiveCow {
    public static int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);

        int left = 1;
        int right = arr[arr.length - 1] - arr[0];
        int res = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(canPlace(arr, k, mid)) {
                res = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return res;
    }

    public static boolean canPlace(int[] arr, int k, int mid) {
        int cows = 1;
        int prevPos = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int dist = arr[i] - prevPos;
            if(dist < mid)
                continue;
            cows++;
            prevPos = arr[i];
        }

        if(cows >= k) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};

        System.out.println(aggressiveCows(arr, 3));
    }
}
