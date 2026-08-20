package TwoPointers;

public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4, -3, -2, -1};

        int left = 0;
        int right = nums.length - 1;

        // while(left < right) {                                                           //----------|
        //     if(Math.abs(nums[left]) < Math.abs(nums[right])) {                          //          |
        //         nums[right] = nums[right] * nums[right];                                //          |
        //         right--;                                                                //          |
        //     } else if(Math.abs(nums[left]) > Math.abs(nums[right])){                    //          |
        //         nums[left] = nums[left] * nums[left];                                   //          |
        //         int temp = nums[right];                                                 //          |-------------> This solution is only for the case the array +ve and both half -ve and +ve array
        //         nums[right] = nums[left];                                               //          |               So optimal will be down 👇
        //         nums[left] = temp;                                                      //          |
        //         nums[right] = nums[right] * nums[right];                                //          |
        //         right--;                                                                //          |
        //     }                                                                           //          |
        // }                                                                               //----------|

        int result[] = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if(leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    
}
