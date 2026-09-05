// Given an array arr[], find the sub-array containing at least one number which has the minimum sum and return its sum.

// Examples :

// Input: arr[] = [3,-4, 2,-3,-1, 7,-5]
// Output: -6
// Explanation: The subarray is [-4,2,-3,-1] = -6
// Input: arr[] = [2, 6, 8, 1, 4]
// Output: 1
// Explanation: The subarray is [1] = 1

// Constraints:
// 1 ≤ arr.size() ≤ 106
// -107 ≤ arr[i] ≤ 107

package KadaneAlgorithmPattern;

public class MinSubArray {
        public static void main(String[] args) {
        int [] arr = {3,-4,2,-3,-1,7,-5};
        int [] arr1 = {2, 6, 8, 1, 4};

        System.out.println(minSubArray(arr));
        System.out.println(minSubArray(arr1));
    }

    public static int minSubArray(int []arr) {
        int currSum = arr[0];
        int result = arr[0];

        for(int i = 1; i < arr.length; i++) {
            currSum = Math.min(arr[i], arr[i] + currSum);
            result = Math.min(result, currSum);
        }

        return result;
    }
}
