package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSumZero {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};

        Arrays.sort(arr);
        System.out.println(triplets(arr));
    }

    public static List<List<Integer>> triplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements for the first position
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    // Skip duplicate elements for left and right pointers
                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
