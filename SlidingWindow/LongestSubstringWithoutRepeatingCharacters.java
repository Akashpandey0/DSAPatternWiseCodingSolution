// Given a string s, find the length of the longest substring without duplicate characters.

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

package SlidingWindow;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";

        System.out.println(longestSubstringWithoutRepeatingCharacters(s));
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right;
        int maxLen = 0;

        for(right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);

            while(map.size() < right - left + 1) {
                char lChar = s.charAt(left);
                map.put(lChar, map.get(lChar) - 1);
                if(map.get(lChar) == 0) map.remove(lChar);

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
