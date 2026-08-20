package TwoPointers;

import java.util.Arrays;

class TwoSum {
    public static void main(String[] args) {
        int [] arr = {7,2,11,15};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int [] sum = new int[2];

            if(nums[left] + nums[right] == target) {
                sum[0] = nums[left];
                sum[1] = nums[right];
                return sum;
            } else if(nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // Return an invalid pair if no solution is found
    }
}