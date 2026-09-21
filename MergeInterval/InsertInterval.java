// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
// Two intervals are considered overlapping if they share at least one point.
// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
// Return intervals after the insertion.
// Note that you don't need to modify intervals in-place. You can make a new array and return it.
// Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]

// Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

// Constraints:
// 0 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 105
// intervals is sorted by starti in ascending order.
// newInterval.length == 2
// 0 <= start <= end <= 105

package MergeInterval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };

        int[][] intervals1 = { { 1, 3 }, { 6, 9 } };
        int[] newInterval1 = { 2, 5 };

        int [][]mergeInsert = insert(intervals, newInterval);
        System.out.println("mergeInsert:");
        for(int [] in: mergeInsert){
            System.out.println("[" + in[0] + ", " + in[1] + "]");
        }

        int[][] mergeInsert1 = (insert(intervals1, newInterval1));
        System.out.println("mergeInsert1:");
        for(int [] in: mergeInsert1){
            System.out.println("[" + in[0] + ", " + in[1] + "]");
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();

        boolean insert = false;

        for(int i = 0; i < intervals.length; i++) {
            if(insert == false && intervals[i][0] >= newInterval[0]) {
                newIntervals.add(new int [] {newInterval[0], newInterval[1]});
                insert = true;
            }
            newIntervals.add(new int [] {intervals[i][0], intervals[i][1]});
        }

        if(!insert) newIntervals.add(new int [] {newInterval[0], newInterval[1]});

        List<int[]> merge = new ArrayList<>();
        int start1 = newIntervals.get(0)[0];
        int end1 = newIntervals.get(0)[1];

        for(int i = 1; i < newIntervals.size(); i++) {
            int start2 = newIntervals.get(i)[0];
            int end2 = newIntervals.get(i)[1];

            if(end1 >= start2) {
                end1 = Math.max(end1,end2);
            }
            else {
                merge.add(new int[] {start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }
        merge.add(new int[] {start1,end1});

        return merge.toArray(new int[merge.size()][]);
    }
}
