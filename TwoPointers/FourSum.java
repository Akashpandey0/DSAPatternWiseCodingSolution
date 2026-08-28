package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int [] nums = {1,0,-1,0,-2,2};
        int target = 0;

        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int [] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates for the first number
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Skip duplicates for the second number
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // Skip duplicates for the third and fourth numbers
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
