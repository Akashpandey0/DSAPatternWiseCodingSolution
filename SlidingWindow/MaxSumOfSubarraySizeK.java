package SlidingWindow;

public class MaxSumOfSubarraySizeK {
    public static void main(String[] args) {
        int [] num = {100,200,300,400};

        int k = 2;

        System.out.println("Brute force Approach: " + maxSumBruteForce(num, k));
        System.out.println("Optimized Sliding Window Approach:" + maxSumOptimized(num,k));
    }

    // Time Complexity: O(n*k)
    public static int maxSumBruteForce(int [] num, int k) {
        int n = num.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i <= n - k; i++) {
            int windowSum = 0;
            for(int j = i; j < i + k; j++) {
                windowSum += num[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }


    // Time Complexity: O(n)
    public static int maxSumOptimized(int [] num, int k) {
        int maxSum = 0;
        int windowSum = 0;

        int windowStart = 0;
        int windowEnd = k - 1;

        for(int i = 0; i <= windowEnd; i++) {
            windowSum += num[i];
        }

        while(windowEnd < num.length) {
            maxSum = Math.max(maxSum, windowSum);
            windowStart++;
            windowEnd++;
            
            if(windowEnd == num.length) {
                break;
            }
            windowSum = windowSum - num[windowStart - 1] + num[windowEnd];
        }
        return maxSum;
    }

}
