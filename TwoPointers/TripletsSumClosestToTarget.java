package TwoPointers;

import java.util.Arrays;

public class TripletsSumClosestToTarget {
    public static void main(String[] args) {
        int [] nums = {0,0,0};
        int target = 1;

        Arrays.sort(nums);
        System.out.println(tripletsClosest(nums, target));
    }

    public static int tripletsClosest(int [] nums, int target) {
        int n = nums.length;
        int max_diff = Integer.MAX_VALUE;
        int closestSum = Integer.MIN_VALUE;

        for(int i = 0; i < n-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target) {
                    left++;
                    right--;
                    return sum;
                }
                else if(sum < target) {
                    left++;
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                }
                else {
                    right--;
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }
                if(Math.abs(target - sum) < max_diff) {
                    max_diff = Math.abs(target - sum);
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }
}
