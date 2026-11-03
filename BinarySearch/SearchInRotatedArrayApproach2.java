package BinarySearch;

public class SearchInRotatedArrayApproach2 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            //part1
            if(nums[mid] > nums[nums.length - 1]) {
                if(nums[mid] < target) left = mid + 1;
                else {
                    if(nums[0] > target) left = mid + 1;
                    else right = mid - 1;
                }
            }

            //part2
            else {
                if(nums[mid] > target) right = mid - 1;
                else {
                    if(nums[nums.length - 1] < target) right = mid - 1;
                    else left = mid + 1;
                }
            }
        }
        return -1;
    }
}
