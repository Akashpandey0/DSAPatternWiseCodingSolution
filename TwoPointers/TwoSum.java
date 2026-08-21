package TwoPointers;

import java.util.Arrays;

class TwoSum {
    public static void main(String[] args) {
        int [] arr = {3,2,4};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            // int [] sum = new int[2]; using extra array is not necessary, we can directly return the pair

            if(nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if(nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // Return an invalid pair if no solution is found
    }
}