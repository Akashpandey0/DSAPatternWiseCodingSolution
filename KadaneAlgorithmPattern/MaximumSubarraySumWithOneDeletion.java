// Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

// Note that the subarray needs to be non-empty after deleting one element.

// Example 1:
// Input: arr = [1,-2,0,3]
// Output: 4
// Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.

// Example 2:
// Input: arr = [1,-2,-2,3]
// Output: 3
// Explanation: We just choose [3] and it's the maximum sum.

// Example 3:
// Input: arr = [-1,-1,-1,-1]
// Output: -1
// Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.

// Constraints:
// 1 <= arr.length <= 105
// -104 <= arr[i] <= 104

package KadaneAlgorithmPattern;

public class MaximumSubarraySumWithOneDeletion {
    public static void main(String[] args) {
        int [] arr = {1,-2,0,3};
        int [] arr1 = {1,-2,-2,3};
        int [] arr2 = {-1,-1,-1,-1};

        System.out.println(maxSubArraySumWithOneDeletion(arr));
        System.out.println(maxSubArraySumWithOneDeletion(arr1));
        System.out.println(maxSubArraySumWithOneDeletion(arr2));
    }

    public static int maxSubArraySumWithOneDeletion(int []arr) {
        int noDel = arr[0];
        int oneDel = Integer.MIN_VALUE;
        int res = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int prevNoDel = noDel;
            int prevOneDel = oneDel;

            noDel = Math.max(arr[i], arr[i] + noDel);

            int v2 = prevOneDel;
            if(prevOneDel == Integer.MIN_VALUE) {
                v2 = arr[i];
            }
            else {
                v2 = arr[i] + prevOneDel;
            }
            oneDel = Math.max(v2, prevNoDel);

            res = Math.max(res, Math.max(oneDel, noDel));
        }

        return res;
    }
}

