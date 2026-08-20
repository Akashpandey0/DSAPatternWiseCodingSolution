package TwoPointers;

public class RemoveDuplicatesfromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }

        public static int removeDuplicates(int[] nums) {
        int idx = 2;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[idx-2]) {
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }
}
