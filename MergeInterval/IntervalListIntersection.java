// You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
// Return the intersection of these two interval lists.
// A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
// The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

// Example 1:
// Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
// Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

// Example 2:
// Input: firstList = [[1,3],[5,9]], secondList = []
// Output: []

// Constraints:
// 0 <= firstList.length, secondList.length <= 1000
// firstList.length + secondList.length >= 1
// 0 <= starti < endi <= 109
// endi < starti+1
// 0 <= startj < endj <= 109 
// endj < startj+1

package MergeInterval;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

        int [][] firstList1 = {{1,3},{5,9}};
        int [][] secondList1 = {};

        int[][] res = intervalIntersection(firstList1, secondList1);
        System.out.println("result1:");
        for(int[] arr : res) {
            System.out.print("[" + arr[0] + "," + arr[1] + "] ");
        }

        int [][] res1 = intervalIntersection(firstList, secondList);
        System.out.println("result2:");
        for(int[] arr : res1) {
            System.out.print("[" + arr[0] + ", " + arr[1] + "] ");
        }
    }
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            if(start1 <= start2) {
                if(end1 >= start2) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    intersection.add(new int[] {s,e});
                }
            }
            else {
                if(end2 >= start1) {
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    intersection.add(new int[] {s,e});
                }
            }

            if(end1 <= end2) i++;
            else j++;
        }
        return intersection.toArray(new int[intersection.size()][]);
    }
}
