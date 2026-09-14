// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

// Example 3:
// Input: intervals = [[4,7],[1,4]]
// Output: [[1,7]]
// Explanation: Intervals [1,4] and [4,7] are considered overlapping.

// Constraints:
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

package MergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
public static void main(String[] args) {
    
        // Example 1:
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result1 = merge(intervals1);
    
        // Print result
        System.out.println("Result1");
        for(int[] interval : result1) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
        // Output: [1,6] [8,10] [15,18]
    
        // Example 2:
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] result2 = merge(intervals2);
    
        // Print result
        System.out.println("Result2: ");
        for(int[] interval : result2) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
        // Output: [1,5]
    
        // Example 3:
        int[][] intervals3 = {{4,7},{1,4}};
        int[][] result3 = merge(intervals3);
    
        // Print result
        System.out.println("Result3");
        for(int[] interval : result3) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    // Output: [1,7]
    }

    public static int[][] merge(int [][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // 1. Must sort by start time first
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));;
        List<int[]> res = new ArrayList<>();
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];



        for(int i = 1; i < intervals.length; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1 >= start2) {
                start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            }
            res.add(new int[] {start1, end1});
            start1 = start2;
            end1 = end2;
        }
        res.add(new int[] {start1, end1});

        return res.toArray(new int[res.size()][]);
    }
}

