package TwoPointers;

import java.util.Arrays;

public class TripletsSumSmaller {
    public static void main(String[] args) {
        int [] nums = {-2, 0, 1, 3};
        int givenSum = 2;

        Arrays.sort(nums);
        System.out.println(tripletsSmaller(nums, givenSum));
    }

    public static int tripletsSmaller(int [] nums, int givenSum) {
        int n = nums.length;
        int smallerSum = 0;

        for(int i = 0; i < n-2; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < givenSum) {
                    smallerSum += right - left;
                    left++;
                }
                else right--;
            }
        }
        return smallerSum;
    }
}
