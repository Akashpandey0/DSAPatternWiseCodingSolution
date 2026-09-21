// You are given a 2D array arr[][] which represents a set of intervals, where each element arr[i] = [start, end] defines an interval.
// Your task is to determine if any two intervals in the given set overlap.

// Note: Two intervals [a, b] and [c, d] overlap if they have at least one common value, i.e., a ≤ d and c ≤ b.

// Examples:
// Input: n = 4, arr[][] = [[1, 3], [5, 7], [2, 4], [6, 8]]
// Output: true
// Explanation: The intervals [1, 3] and [2, 4] overlap.

// Input: n = 4, arr[][] = [[1, 3], [7, 9], [4, 6], [10, 13]]
// Output: false
// Explanation: No pair of intervals overlap.

// Constraints:
// 1 ≤ arr[i][0] < arr[i][1] ≤ 105
// 2 ≤ arr.size() ≤ 105

package MergeInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class OverlappingIntervals {
    public static void main(String[] args) {
        int [][] arr = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        int [][] arr1 = {{1, 3}, {7, 9}, {4, 6}, {10, 13}};

        System.out.println(overlappingIntervals(arr));
        System.out.println(overlappingIntervals(arr1));
    }

    public static boolean overlappingIntervals(int [][] arr) {

        if(arr.length <= 1) return false;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int end1 = arr[0][1];

        for(int i = 1; i < arr.length; i++) {
            int start2 = arr[i][0];
            int end2 = arr[i][1];

            if(end1 >= start2) {
                return true;
            }
            end1 = Math.max(end1, end2);
        }
        return false;
    }
}