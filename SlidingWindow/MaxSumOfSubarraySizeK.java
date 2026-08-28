package SlidingWindow;

public class MaxSumOfSubarraySizeK {
    public static void main(String[] args) {
        int [] num = {100,200,300,400};

        int k = 2;

        System.out.println(maxSum(num,k));
    }
    public static int maxSum(int [] num, int k) {
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
