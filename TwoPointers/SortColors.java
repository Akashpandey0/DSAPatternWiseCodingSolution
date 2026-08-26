package TwoPointers;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};

        sortColors(nums);
    }

    public static void sortColors(int [] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                // swap with low
                int temp = nums[mid];
                nums[mid++] = nums[low];
                nums[low++] = temp;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else {
                // swap with high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high--] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
